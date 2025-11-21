package com.farm.app.owner.controller;

import com.farm.app.owner.dto.OwnerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface OwnerController {

    @PostMapping(path = "owner" )
    ResponseEntity<OwnerDto> save(@RequestBody OwnerDto ownerDto)  ;


    @GetMapping (path = "owners")
    ResponseEntity<List<OwnerDto>> getAllOwner();


    @PutMapping (path = "owner/{id}")
    ResponseEntity<OwnerDto> update (@RequestBody OwnerDto ownerDto, @PathVariable(name = "id") int id);




}
