package com.project.hibernate.service;

import org.hibernate.Session;

import java.util.Scanner;

public interface DoctorService {
    void selectDoctor(Session session);

    void insertDoctor(Session session, Scanner scanner);

}
