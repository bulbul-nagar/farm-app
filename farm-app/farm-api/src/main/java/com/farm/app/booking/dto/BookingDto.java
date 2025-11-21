package com.farm.app.booking.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data

public class BookingDto {

    private int id;

    private int equipmentId;

    private  int renterId;

    private String status;

    private  String startDate;

    private  String endDate;


}
