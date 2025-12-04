package com.farm.app.equipment.controller.impl;

import com.farm.app.equipment.controller.EquipmentController;
import com.farm.app.equipment.dto.EquipmentDto;
import com.farm.app.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class EquipmentControllerImpl implements EquipmentController {

    @Autowired
    private EquipmentService equipmentService;


    @Override
    public ResponseEntity<EquipmentDto> add(EquipmentDto equipmentDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.equipmentService.add(equipmentDto));
    }

    @Override
    public ResponseEntity<EquipmentDto> update(EquipmentDto equipmentDto, int id) {
        return ResponseEntity.ok(this.equipmentService.update(equipmentDto,id));
    }

    @Override
    public ResponseEntity<List<EquipmentDto>> getAllEquipment() {
        return ResponseEntity.ok(this.equipmentService.getAllEquipment());
    }
}
