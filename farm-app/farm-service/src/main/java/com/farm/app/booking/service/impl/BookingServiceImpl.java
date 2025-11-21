package com.farm.app.booking.service.impl;

import com.farm.app.booking.dto.BookingDto;
import com.farm.app.booking.entity.Booking;
import com.farm.app.booking.repository.BookingRepository;
import com.farm.app.booking.service.BookingService;
import com.farm.app.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.InvocationTargetException;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository)
    {

        this.bookingRepository = bookingRepository;
    }
@ResponseStatus(HttpStatus.CREATED)
    @Override
    public BookingDto save(BookingDto bookingDto) {

    try {

        Booking  booking = MapperUtility.sourceToTarget(bookingDto, Booking.class);
        booking =bookingRepository.saveAndFlush(booking);
        return MapperUtility.sourceToTarget(booking , BookingDto.class);
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

       booking.setEquipmentId(booking.getId());
       booking.setStatus(booking.getStatus());
       booking.setStartDate(booking.getStartDate());
       booking.setEndDate(booking.getEndDate());
        try {
            return MapperUtility.sourceToTarget(booking ,BookingDto.class);
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
    public void delete(int id) {
       bookingRepository.deleteById(id);

    }
}
