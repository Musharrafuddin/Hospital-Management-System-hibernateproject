package com.project.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_table")
public class Patient {
    @Id
    private Integer pId;
    @Column(name = "Name",nullable = false)
    private String name;
    @Column(name = "age",nullable = false)
    private Integer age;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "Phone_no",nullable = false)
    private Integer phn_No;

    @OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
    private List<Appointment> appintments = new ArrayList<>();

    @OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
    private List<Invoice> invoices = new ArrayList<>();

    @OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
    private List<Prescription> prescriptions = new ArrayList<>();

    @Override
    public String toString() {
        return "Patient{" +
                "pId=" + pId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phn_No=" + phn_No +
                ",}'";
    }
}

