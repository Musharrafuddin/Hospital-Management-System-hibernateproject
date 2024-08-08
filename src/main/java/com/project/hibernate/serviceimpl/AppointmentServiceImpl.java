package com.project.hibernate.serviceimpl;

import com.project.hibernate.entity.Appointment;
import com.project.hibernate.entity.Doctor;
import com.project.hibernate.entity.Patient;
import com.project.hibernate.entity.Prescription;
import com.project.hibernate.service.AppointmentService;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class AppointmentServiceImpl implements AppointmentService {
Scanner scanner;
Session session;

    @Override
    public void insertAppointment(Session session, Scanner scanner) {
        System.out.println("Enter values of id,Date,patient id, doctor id ");
        this.scanner = scanner;
        this.session = session;
        session.beginTransaction();
        Appointment a = new Appointment();
        System.out.println("Enter appointment id :");
        a.setId(scanner.nextInt());
        System.out.println("Enter Date :");
        a.setDate((scanner.next()));
        System.out.println("Enter patient id");
        Patient patient =session.get(Patient.class,scanner.nextInt());
        a.setPatient(patient);
        System.out.println("Enter doctor id");
        Doctor doctor =session.get(Doctor.class,scanner.nextInt());
        a.setDoctor(doctor);


        session.save(a);
        session.getTransaction().commit();
        this.session.close();
    }

    @Override
    public void getAppointment(Session session, Scanner scanner) {
        System.out.println("Enter  id:");
        this.scanner = scanner;
        this.session = session;
        int id = scanner.nextInt();
        Appointment appointment = session.get(Appointment.class, id);
        System.out.println(appointment);
    }
    @Override
    public void selectAppointment(Session session){
        this.session = session;
        Query createQuery = session.createQuery("from Appointment");
        List<Appointment> list = createQuery.list();

        for (Appointment a : list)
            System.out.println(a);
        this.session.close();
    }
}
