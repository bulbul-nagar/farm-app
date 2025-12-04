package com.farm.app.equipment.service;

import com.farm.app.equipment.dto.EquipmentDto;

import java.util.List;

public interface EquipmentService {

    EquipmentDto add (EquipmentDto equipmentDto);

    EquipmentDto update (EquipmentDto equipmentDto , int id);

    void delete (int id );


    List<EquipmentDto> getAllEquipment();

}
