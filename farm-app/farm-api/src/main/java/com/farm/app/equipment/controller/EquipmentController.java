package com.farm.app.equipment.controller;


import com.farm.app.equipment.dto.EquipmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@ResponseBody
public interface EquipmentController  {

    @PostMapping(path = "equipment")
    ResponseEntity<EquipmentDto> add (@RequestBody EquipmentDto equipmentDto);

    @PutMapping(path = "equipment/{id}")
    ResponseEntity<EquipmentDto>update (@RequestBody EquipmentDto equipmentDto , @PathVariable int id);

    @GetMapping(path = "equipments")
    ResponseEntity<List<EquipmentDto>> getAllEquipment();





}
