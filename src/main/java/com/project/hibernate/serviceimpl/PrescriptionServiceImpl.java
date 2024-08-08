package com.project.hibernate.serviceimpl;

import com.project.hibernate.entity.Patient;
import com.project.hibernate.entity.Prescription;
import com.project.hibernate.service.PrescriptionService;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;
import java.util.Scanner;

public class PrescriptionServiceImpl implements PrescriptionService {

    Session session;
    Scanner scanner;

    @Override
    public void insertPrescription(Session session, Scanner scanner) {
        System.out.println("Enter values of Prescription_Num,Medication_name,Date");
        this.scanner = scanner;
        this.session = session;
        session.beginTransaction();
        Prescription pr = new Prescription();
        System.out.println("Enter Prescription_Num :");

        pr.setPrescription_Num(scanner.nextInt());
        System.out.println("Enter patient id :");
        Patient patient =session.get(Patient.class,scanner.nextInt());
        pr.setPatient(patient);
        System.out.println("Enter Medication_name :");
        pr.setMedication_name(scanner.next());
        System.out.println("Enter Date :");

        pr.setDate(scanner.next());

        session.save(pr);
        session.getTransaction().commit();
        this.session.close();
    }

    @Override
    public void getPrescription(Session session, Scanner scanner) {
            System.out.println("Enter  id:");
            this.scanner = scanner;
            this.session = session;
            int id = scanner.nextInt();
            Prescription prescription = session.get(Prescription.class, id);
            System.out.println(prescription);

        }
    @Override
    public void selectPrescription(Session session){
        this.session = session;
        Query createQuery = session.createQuery("from Prescription");
        List<Prescription> list = createQuery.list();

        for (Prescription pr : list)
            System.out.println(pr);
        this.session.close();
    }
    }
