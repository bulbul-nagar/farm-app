package com.farm.app.renter.controller.impl;

import com.farm.app.renter.controller.RenterController;
import com.farm.app.renter.dto.RenterDto;
import com.farm.app.renter.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class RenterControllerImpl implements RenterController  {

    private final RenterService renterService;

    @Autowired
    public RenterControllerImpl(RenterService renterService)
    {
        this.renterService = renterService;
    }

    @Override
    public ResponseEntity<RenterDto> save(RenterDto renterDto) {
        return new ResponseEntity<>(this.renterService.save(renterDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RenterDto> getRenterById(int id) {
        return ResponseEntity.ok(this.renterService.getRenterById(id));
    }

    @Override
    public ResponseEntity<List<RenterDto>> allRenters() {
        return ResponseEntity.ok(this.renterService.allRenters());
    }

    @Override
    public ResponseEntity<RenterDto> update(RenterDto renterDto, int id) {
        return ResponseEntity.ok(this.renterService.update(renterDto, id));
    }

    @Override
    public void delete(int id) {
        this.renterService.delete(id);
    }
}
