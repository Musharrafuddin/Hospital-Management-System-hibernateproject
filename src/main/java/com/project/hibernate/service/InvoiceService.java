package com.project.hibernate.service;

import org.hibernate.Session;

import java.util.Scanner;

public interface InvoiceService {
    void insertInvoice(Session session, Scanner scanner);

    void getInvoice(Session session, Scanner scanner);

    void selectInvoice(Session session);
}
