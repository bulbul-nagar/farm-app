package com.farm.app.equipment.service;

import com.farm.app.equipment.dto.EquipmentDto;

public interface EquipmentService {

    EquipmentDto add (EquipmentDto equipmentDto);

    EquipmentDto update (EquipmentDto equipmentDto , int id);

    void delete (int id );


}
