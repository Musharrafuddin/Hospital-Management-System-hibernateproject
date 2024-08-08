package com.project.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prescription {
    @Id
    private Integer prescription_Num;
    @Column(nullable = false)

    private String medication_name;
    @Column(nullable = false)

    private String date;

    @ManyToOne()
    @JoinColumn(name = "pId",nullable = false)
    private Patient patient = new Patient();

    @Override
    public String toString() {
        return "Prescription{" +
                "prescription_Num=" + prescription_Num +
                ", medication_name='" + medication_name + '\'' +
                ", date='" + date + "}'";
    }
}

