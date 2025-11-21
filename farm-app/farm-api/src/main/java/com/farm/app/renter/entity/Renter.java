package com.farm.app.renter.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "RENTERS")
public class Renter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTER_ID")
    private int id;

    @Column(name = "RENTER_NAME" , columnDefinition = "VARCHAR(20) NOT NULL", nullable = false,updatable = false)
    private String name;

    @Column(name = "EMAIL" , unique = true )
    private String email;

    @Column (name=" PHONE " ,unique = true)
    private  String phone;

    @Column ( name = " PASSWORD " , unique = true)
    private  String password ;

    @Column (name = " ADDRESS " , columnDefinition =  "VARCHAR(30)")
    private String address;

}

