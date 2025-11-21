package com.farm.app.owner.controllerimpl;

import com.farm.app.owner.controller.OwnerController;
import com.farm.app.owner.dto.OwnerDto;
import com.farm.app.owner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OwnerControllerImpl implements OwnerController {

    @Autowired
    private  OwnerService ownerService ;


    @Override
    public ResponseEntity<OwnerDto> save(OwnerDto ownerDto) {
        return ResponseEntity.ok(this.ownerService.save (ownerDto));
    }

    @Override
    public ResponseEntity<List<OwnerDto>> getAllOwner() {

        return ResponseEntity.ok(this.ownerService.getAllOwner());
    }

    @Override
    public ResponseEntity<OwnerDto> update(OwnerDto ownerDto, int id) {
        return ResponseEntity.ok(this.ownerService.update(ownerDto , id ));

    }
}
