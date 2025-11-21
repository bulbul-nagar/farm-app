package com.farm.app.owner.service;

import com.farm.app.owner.dto.OwnerDto;

import java.util.List;

public interface OwnerService {
    OwnerDto save(OwnerDto ownerDto);

    List<OwnerDto> getAllOwner();

    OwnerDto update(OwnerDto ownerDto, int id);
}
