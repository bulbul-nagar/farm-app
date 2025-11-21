package com.farm.app.equipment.dto;

import lombok.Data;
@Data
public class EquipmentDto {


    private  int Id;
    private String name;
    private int ownerId;
    private long pricePerDay;
    private  String type;
    private String availabilityStartDate;
    private String  availabilityEndDate;
    private  String status;

}
