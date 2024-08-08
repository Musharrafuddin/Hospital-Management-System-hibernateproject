package com.project.hibernate.service;


import org.hibernate.Session;
import java.util.Scanner;

public interface PatientService {

    void selectPaitent(Session session);

    void insertPaitent(Session session, Scanner scanner);

    void updatePaitent(Session session, Scanner scanner);

    void deletePaitent(Session session, Scanner scanner);

    void getPaitent(Session session, Scanner scanner);

}


