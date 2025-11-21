package com.farm.app.renter.repository;

import com.farm.app.renter.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository  extends JpaRepository<Renter, Integer> {

}
