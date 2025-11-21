package com.farm.app.renter.controller;

import com.farm.app.renter.dto.RenterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
public interface RenterController {

    @PostMapping(path = "renter")
    ResponseEntity<RenterDto> save(@RequestBody RenterDto renterDto);

    @GetMapping(path = "renter/{id}")
    ResponseEntity<RenterDto> getRenterById(@PathVariable(name = "id")  int id);

    @GetMapping(path = "renters")
    ResponseEntity<List<RenterDto>> allRenters();

    @PutMapping(path = "renter/{id}")
    ResponseEntity<RenterDto> update(@RequestBody RenterDto renterDto, @PathVariable(name = "id") int id);

    @DeleteMapping(path = "renter/{id}")
    void delete(@PathVariable(name = "id") int id);
}
