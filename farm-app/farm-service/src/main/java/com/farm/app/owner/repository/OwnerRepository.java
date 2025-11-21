package com.farm.app.owner.repository;

import com.farm.app.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner , Integer> {
}
