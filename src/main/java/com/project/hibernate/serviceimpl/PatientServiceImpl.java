package com.project.hibernate.serviceimpl;

import org.hibernate.Session;
import com.project.hibernate.service.PatientService;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;
import com.project.hibernate.entity.Patient;
public class PatientServiceImpl implements PatientService {

    Session session;

    Scanner scanner;

    @Override
    public void selectPaitent(Session session) {
        this.session = session;
        Query createQuery = session.createQuery("from Patient");
        List<Patient> list = createQuery.list();

        for (Patient p : list)
            System.out.println(p);
        this.session.close();

    }

    @Override
    public void insertPaitent(Session session, Scanner scanner) {
        System.out.println("Enter values of Patient_Id,name,age,gender,Phn_no");
        this.scanner = scanner;
        this.session = session;
        session.beginTransaction();
        Patient p = new Patient();
        System.out.println("Enter  Patient_Id");
        p.setPId(scanner.nextInt());
        System.out.println("Enter name");
        p.setName(scanner.next());
        System.out.println("Enter age");
        p.setAge(scanner.nextInt());
        System.out.println("Enter gender");
        p.setGender(scanner.next());
        System.out.println("Enter Phn_no");
        p.setPhn_No(scanner.nextInt());

        session.save(p);
        session.getTransaction().commit();
        this.session.close();

    }

    @Override
    public void updatePaitent(Session session, Scanner scanner) {
        System.out.println("Enter values of Patient_Id,name,age,gender,Phn_no");
        this.scanner = scanner;
        this.session = session;
        session.beginTransaction();
        Patient p = new Patient();
        System.out.println("Enter  Patient_Id");
        p.setPId(scanner.nextInt());
        System.out.println("Enter name");
        p.setName(scanner.next());
        System.out.println("Enter age");
        p.setAge(scanner.nextInt());
        System.out.println("Enter gender");
        p.setGender(scanner.next());
        System.out.println("Enter Phn_no");
        p.setPhn_No(scanner.nextInt());

        session.saveOrUpdate(p);
        session.getTransaction().commit();
        this.session.close();

    }

    @Override
    public void deletePaitent(Session session, Scanner scanner) {
        System.out.println("Enter Patient id :");
        this.scanner = scanner;
        this.session = session;
        session.beginTransaction();
        Patient p =new Patient();
        p.setPId(scanner.nextInt());
        session.delete(p);
        session.getTransaction().commit();
        this.session.close();

    }

    @Override
    public void getPaitent(Session session, Scanner scanner) {
        System.out.println("Enter Patient id:");
        this.scanner = scanner;
        this.session = session;
        int id = scanner.nextInt();
        Patient patient = session.get(Patient.class, id);
        System.out.println(patient);

    }


}
