package com.farm.app.equipment.service.impl;

import com.farm.app.equipment.dto.EquipmentDto;
import com.farm.app.equipment.entity.Equipment;
import com.farm.app.equipment.repository.EquipmentRepository;
import com.farm.app.equipment.service.EquipmentService;
import com.farm.app.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;


    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public EquipmentDto add(EquipmentDto equipmentDto) {
        try {
            Equipment equipment = MapperUtility.sourceToTarget(equipmentDto, Equipment.class);
            equipment = equipmentRepository.saveAndFlush(equipment);
            return MapperUtility.sourceToTarget(equipment, EquipmentDto.class);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        // return equipmentRepository.save(equipmentDto);
    }

    @Override
    public EquipmentDto update(EquipmentDto equipmentDto, int id) {
        Equipment equipment = this.equipmentRepository.findById(id).orElseThrow();

        // Update fields
        if(equipmentDto.getAvailabilityEndDate() != null)
            equipment.setAvailabilityEndDate(equipmentDto.getAvailabilityEndDate());
        if(equipmentDto.getAvailabilityStartDate() != null)
            equipment.setAvailabilityStartDate(equipmentDto.getAvailabilityStartDate());
        if(equipmentDto.getOwnerId() != 0)
            equipment.setOwnerId(equipmentDto.getOwnerId());

        // FIX: Allow status updates
        if(equipmentDto.getStatus() != null) {
            equipment.setStatus(equipmentDto.getStatus());
        }

        equipment = equipmentRepository.save(equipment); // Save changes

        try {
            return MapperUtility.sourceToTarget(equipment, EquipmentDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(int id) {
        equipmentRepository.deleteById(id);

    }

    @Override
    public List<EquipmentDto> getAllEquipment() {
        // Fetch all equipment entities from the database
        List<Equipment> equipmentList = equipmentRepository.findAll();

        // Convert the list of Entities to DTOs
        return equipmentList.stream().map(equipment -> {
            try {
                return MapperUtility.sourceToTarget(equipment, EquipmentDto.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

}
