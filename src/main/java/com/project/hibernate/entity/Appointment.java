package com.project.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
    @Id
    private Integer Id;
@Column(nullable = false)
    private String date;

    @ManyToOne()
    @JoinColumn(name = "pId",nullable = false)
    private Patient patient = new Patient();

    @ManyToOne()
    @JoinColumn(name = "dId",nullable = false)
    private Doctor doctor = new Doctor();

    @Override
    public String toString() {
        return "Appointment{" +
                "Id=" + Id +
                ", date='" + date + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}


