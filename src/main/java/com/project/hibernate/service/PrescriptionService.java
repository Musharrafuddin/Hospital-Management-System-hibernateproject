package com.project.hibernate.service;

import org.hibernate.Session;

import java.util.Scanner;

public interface PrescriptionService {

    void insertPrescription(Session session, Scanner scanner);

    void getPrescription(Session session, Scanner scanner);

    void selectPrescription(Session session);
}
