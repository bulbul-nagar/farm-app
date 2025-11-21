package com.farm.app.booking.repository;

import com.farm.app.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking ,Integer>
{
}
