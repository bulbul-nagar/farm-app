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

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;


    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public EquipmentDto add(EquipmentDto equipmentDto) {
        try {
            Equipment equipment = MapperUtility.sourceToTarget(equipmentDto, Equipment.class);
            equipment =equipmentRepository.saveAndFlush(equipment);
            return MapperUtility.sourceToTarget(equipment ,EquipmentDto.class);

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

        equipment.setAvailabilityEndDate(equipmentDto.getAvailabilityEndDate());
        equipment.setAvailabilityStartDate(equipmentDto.getAvailabilityStartDate());
        equipment.setOwnerId(equipmentDto.getOwnerId());
        try {
            return MapperUtility.sourceToTarget(equipment ,EquipmentDto.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        equipmentRepository.deleteById(id);

    }
}
