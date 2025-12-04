package com.farm.app.booking.service.impl;

import com.farm.app.booking.dto.BookingDto;
import com.farm.app.booking.entity.Booking;
import com.farm.app.booking.repository.BookingRepository;
import com.farm.app.booking.service.BookingService;
import com.farm.app.equipment.entity.Equipment;
import com.farm.app.equipment.repository.EquipmentRepository;
import com.farm.app.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {

        this.bookingRepository = bookingRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public BookingDto save(BookingDto bookingDto) {

        try {

            Booking booking = MapperUtility.sourceToTarget(bookingDto, Booking.class);
            booking = bookingRepository.saveAndFlush(booking);
            return MapperUtility.sourceToTarget(booking, BookingDto.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public BookingDto update(BookingDto bookingDto, int id) {
        Booking booking = this.bookingRepository.findById(id).orElseThrow();

        // 1. Update Status
        booking.setStatus(bookingDto.getStatus());

        // 2. Logic: If Confirmed, mark Equipment as "Booked"
        if ("Confirmed".equalsIgnoreCase(bookingDto.getStatus())) {
            Equipment equipment = equipmentRepository.findById(booking.getEquipmentId()).orElse(null);
            if (equipment != null) {
                equipment.setStatus("Booked");
                equipmentRepository.save(equipment);
            }
        }

        // 3. Update dates only if provided
        if (bookingDto.getStartDate() != null) booking.setStartDate(bookingDto.getStartDate());
        if (bookingDto.getEndDate() != null) booking.setEndDate(bookingDto.getEndDate());

        booking = bookingRepository.saveAndFlush(booking);

        try {
            return MapperUtility.sourceToTarget(booking, BookingDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        bookingRepository.deleteById(id);

    }

    @Override
    public List<BookingDto> getAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(b -> {
            try {
                return MapperUtility.sourceToTarget(b, BookingDto.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
