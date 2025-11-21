package com.farm.app.booking.service;

import com.farm.app.booking.dto.BookingDto;

public interface BookingService {
    BookingDto save(BookingDto bookingDto);

    BookingDto update(BookingDto bookingDto, int id);

    void delete(int id);

}
