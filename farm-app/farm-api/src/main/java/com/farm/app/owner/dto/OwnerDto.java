package com.farm.app.owner.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OwnerDto {

    private  int Id;
    private  String name;
    private  String email;
    private  String phone;
    private  String password;
}
