package com.project.hibernate.entity;

import com.project.hibernate.entity.Patient;
import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice {
    @Id
    private Integer invoice_Num;
    @Column(nullable = false)

    private String service_Description;
    @Column(nullable = false)

    private Integer total;

    @ManyToOne()
    @JoinColumn(name = "pId",nullable = false)
    private Patient patient= new Patient();

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_Num=" + invoice_Num +
                ", service_Description='" + service_Description + '\'' +
                ", total=" + total +"}'";
    }
}

