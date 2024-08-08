package com.project.hibernate.serviceimpl;

import com.project.hibernate.service.DoctorService;
import com.project.hibernate.entity.Doctor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class DoctorServiceImpl implements DoctorService {

    Scanner scanner;
    Session session;

    @Override
    public void selectDoctor(Session session) {
        this.session = session;
        Query createQuery = session.createQuery("from Doctor");
        List<Doctor> list = createQuery.list();

        for (Doctor d : list)
            System.out.println(d);
        this.session.close();
    }

    @Override
    public void insertDoctor(Session session, Scanner scanner) {
        System.out.println("Enter values of Doctor_Id,name,qualification,specialisation");
        this.scanner = scanner;
        this.session = session;
        session.beginTransaction();
        Doctor d = new Doctor();
        System.out.println("Enter Doctor_Id ");
        d.setDId(scanner.nextInt());
        System.out.println("Enter Doctor name :");
        d.setName(scanner.next());
        System.out.println("Enter qualification :");
        d.setQualification(scanner.next());
        System.out.println("Enter specialisation");

        d.setSpecialization(scanner.next());

        session.save(d);
        session.getTransaction().commit();
        this.session.close();
    }
}
