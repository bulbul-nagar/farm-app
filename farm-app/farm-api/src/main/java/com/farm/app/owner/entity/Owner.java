package com.farm.app.owner.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "OWNER")
public class Owner {

 @Id
 @GeneratedValue (strategy = GenerationType.IDENTITY)
 @Column(name="OWNER_ID")
 private  int Id;

@Column (name = "NAME")
 private  String name;

@Column(name= " Email ")
 private  String email;

@Column (name = " Phone ")
 private  String phone;

@Column (name = " Password")
 private  String password;

}
