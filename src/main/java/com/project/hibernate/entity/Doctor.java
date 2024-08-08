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
public class Doctor {
    @Id
    private Integer dId;
    @Column(name = "Name",nullable = false)
    private String name;
    @Column(nullable = false)

    private String qualification;
    @Column(nullable = false)

    private String specialization;

    @OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
    private List<Appointment> appintments = new ArrayList<>();

    @Override
    public String toString() {
        return "Doctor{" +
                "dId=" + dId +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", specialization='" + specialization + '\'' +
                ", }'";
    }
}

