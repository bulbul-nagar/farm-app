package com.farm.app.renter.service;

import com.farm.app.renter.dto.RenterDto;

import java.util.List;
import java.util.Optional;

public interface RenterService {
    
    
    RenterDto save(RenterDto renterDto);
    
    RenterDto getRenterById(int id);

    List<RenterDto> allRenters();

    RenterDto update(RenterDto renterDto, int id);

    void delete(int id);
}
