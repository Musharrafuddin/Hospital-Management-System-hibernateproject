package com.project.hibernate.service;

import org.hibernate.Session;

import java.util.Scanner;

public interface AppointmentService {

    void insertAppointment(Session session, Scanner scanner);

    void getAppointment(Session session, Scanner scanner);

    void selectAppointment(Session session);
}
