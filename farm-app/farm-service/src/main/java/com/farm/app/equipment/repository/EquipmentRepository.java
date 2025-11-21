package com.farm.app.equipment.repository;

import com.farm.app.equipment.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment , Integer> {

}
