package com.project.hibernate;

import com.project.hibernate.service.*;
import com.project.hibernate.serviceimpl.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;


public class HospitalMain {


    public static void main(String[] args) {

        SessionFactory sFactory = ConfigurationUtility.getSessionFactory();
        Session session = null;

        Scanner scanner =new Scanner(System.in);
System.out.println(" WELCOME TO HOSPITAL MANAGEMENT SYSTEM ");
while (true) {
    System.out.println(" Enter the option : 1-Patient data, 2-Doctor data, 3-Appointments, 4-Invoice, 5-Prescription, 6-Exi3t ");


    switch (scanner.nextInt()) {
        case 1:
            PatientService patientService = new PatientServiceImpl();
            System.out.println("Enter the operation :: 1-New Patient, 2-All Patient's Details, 3-Get patient Details, 4-Update Patient Details,5-Delete Patient");

            switch (scanner.nextInt()) {
                case 1:
                    session = sFactory.openSession();
                    patientService.insertPaitent(session, scanner);
                    break;
                case 2:
                    session = sFactory.openSession();
                    patientService.selectPaitent(session);
                    break;
                case 3:
                    session = sFactory.openSession();
                    patientService.getPaitent(session, scanner);
                    break;
                case 4:
                    session = sFactory.openSession();
                    patientService.updatePaitent(session, scanner);
                    break;
                case 5:
                    session = sFactory.openSession();
                    patientService.deletePaitent(session, scanner);
                    break;
            }break;
        case 2:
            DoctorService doctorService = new DoctorServiceImpl();
            System.out.println("Enter the operation :: 1-New Doctor, 2-Doctor details");

            switch (scanner.nextInt()) {
                case 1:
                    session = sFactory.openSession();
                    doctorService.insertDoctor(session, scanner);
                    break;
                case 2:
                    session = sFactory.openSession();
                    doctorService.selectDoctor(session);
                    break;
            }break;
        case 3:
            AppointmentService appointmentService = new AppointmentServiceImpl();
            System.out.println("Enter the operation :: 1-Book Appointment,2- patient's Appointment , 3-All Appointments");

            switch (scanner.nextInt()) {
                case 1:
                    session = sFactory.openSession();
                    appointmentService.insertAppointment(session, scanner);
                    break;
                case 2:
                    session = sFactory.openSession();
                    appointmentService.getAppointment(session, scanner);
                    break;
                case 3:  session = sFactory.openSession();
                    appointmentService.selectAppointment(session);
                    break;

            }break;
        case 4:
            InvoiceService invoiceService = new InvoiceServiceImpl();
            System.out.println("Enter the operation :: 1-New invoice,2-get patient Invoice 3-All Invoices");

            switch (scanner.nextInt()) {
                case 1:
                    session = sFactory.openSession();
                    invoiceService.insertInvoice(session, scanner);
                    break;
                case 2:
                    session = sFactory.openSession();
                    invoiceService.getInvoice(session, scanner);
                    break;
                case 3:      session = sFactory.openSession();
                    invoiceService.selectInvoice(session);
                    break;
            }break;
        case 5:
            PrescriptionService prescriptionService = new PrescriptionServiceImpl();
            System.out.println("Enter the operation :: 1-New Prescription,2-Patients Prescription , 3-All Prescriptions");

            switch (scanner.nextInt()) {
                case 1:
                    session = sFactory.openSession();
                    prescriptionService.insertPrescription(session, scanner);
                    break;
                case 2:
                    session = sFactory.openSession();
                    prescriptionService.getPrescription(session, scanner);
                    break;
                case 3:
                    session = sFactory.openSession();
                    prescriptionService.selectPrescription(session);
                    break;

            }break;
        case 6:
            System.out.println(" Exiting");
            System.exit(0);
        default:
            System.out.println("Invalid Option");
            break;
    }

}

    }
}