package com.farm.app.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name ="booking")
public class Booking {

    @Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "Booking_Id")
 private int id;

@Column (name = "Equipment_Id")
private int equipmentId;

@Column (name = "Renter_ID")
private  int renterId;

@Column (name="Status")
private String status;

@Column (name = "Start_Date")
private  String startDate;

@Column (name="End_Date")
private  String endDate;


}
