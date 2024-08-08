package com.project.hibernate.serviceimpl;

import com.project.hibernate.entity.Invoice;
import com.project.hibernate.entity.Patient;
import com.project.hibernate.entity.Prescription;
import org.hibernate.Session;
import com.project.hibernate.service.InvoiceService;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;


public class InvoiceServiceImpl implements InvoiceService {

    Session session;

    Scanner scanner;

    @Override
    public void insertInvoice(Session session, Scanner scanner) {
        System.out.println("Enter values of invoice_Num,service_Descriptionage,total");
        this.scanner = scanner;
        this.session = session;
        session.beginTransaction();
        Invoice i = new Invoice();
        System.out.println("Enter  invoice_Num :");
        i.setInvoice_Num(scanner.nextInt());
        System.out.println("Enter patient id");
        Patient patient =session.get(Patient.class,scanner.nextInt());
        i.setPatient(patient);
        System.out.println("Enter service_Descriptionage :");
        i.setService_Description(scanner.next());
        System.out.println("Enter total");
        i.setTotal(scanner.nextInt());

        session.save(i);
        session.getTransaction().commit();
        this.session.close();
    }

    @Override
    public void getInvoice(Session session, Scanner scanner) {
        System.out.println("Enter  id:");
        this.scanner = scanner;
        this.session = session;
        int id = scanner.nextInt();
        Invoice invoice = session.get(Invoice.class, id);
        System.out.println(invoice);
    }
    @Override
    public void selectInvoice(Session session){
        this.session = session;
        Query createQuery = session.createQuery("from Prescription");
        List<Invoice> list = createQuery.list();

        for (Invoice i : list)
            System.out.println(i);
        this.session.close();
    }
}
