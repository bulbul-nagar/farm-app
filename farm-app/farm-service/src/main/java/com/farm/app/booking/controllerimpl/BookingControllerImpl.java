package com.farm.app.booking.controllerimpl;

import com.farm.app.booking.controller.BookingController;
import com.farm.app.booking.dto.BookingDto;
import com.farm.app.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class BookingControllerImpl implements BookingController {

    @Autowired
    private BookingService bookingService;

    @Override
    public ResponseEntity<BookingDto> save(BookingDto bookingDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookingService.save(bookingDto));
    }

    @Override
    public ResponseEntity<BookingDto> update(BookingDto bookingDto, int id) {
        return ResponseEntity.ok(this.bookingService.update(bookingDto,id));
    }

    @Override
    public ResponseEntity<List<BookingDto>> getAllBooking() {
        return ResponseEntity.ok(bookingService.getAllBooking());
    }

    @Override
    public void delete(int id) {
        this.bookingService.delete(id);

    }



}
