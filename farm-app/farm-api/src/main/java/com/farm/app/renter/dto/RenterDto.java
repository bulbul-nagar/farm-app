package com.farm.app.renter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RenterDto {

    private int id;
    private String name;
    private String email;
    private  String phone;
    private  String password ;
    private String address;

    public RenterDto(int id, String name, String email, String address, String phone) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.address = address;
    }
}
