package com.farm.app.booking.controller;

import com.farm.app.booking.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
public interface BookingController {

    @PostMapping(path = "booking")
    ResponseEntity<BookingDto> save(@RequestBody BookingDto bookingDto);

    @PutMapping(path = "booking/{id}")
    ResponseEntity<BookingDto> update(@RequestBody BookingDto bookingDto, @PathVariable int id);

    @GetMapping(path = "bookings")
    ResponseEntity<List<BookingDto>> getAllBooking();

    @DeleteMapping(path = "booking/{id}")
    void delete(@PathVariable(name = "id") int id);
}