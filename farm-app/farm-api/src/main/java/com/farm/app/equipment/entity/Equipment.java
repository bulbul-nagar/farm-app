package com.farm.app.equipment.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name =" Equipment ")
public class Equipment {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name = "Equipment_Id" ,unique = true)
private  int Id;

@Column (name="NAME" ,columnDefinition = "VARCHAR(50) NOT NULL")
private String name;

@Column( name ="OWNER_ID")
private int ownerId;

@Column ( name = " PRICE_PER_DAY")
private long pricePerDay;

@Column (name = "TYPE")
private  String type;

@Column (name =" AVAILABILITY_START_DATE")
private String availabilityStartDate;

@Column (name = "AVAILABILITY_END_DATE")
private String  availabilityEndDate;

@Column (name = "STATUS")
private  String status;

}
