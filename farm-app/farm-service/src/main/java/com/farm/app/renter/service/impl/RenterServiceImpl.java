package com.farm.app.renter.service.impl;

import com.farm.app.renter.dto.RenterDto;
import com.farm.app.renter.entity.Renter;
import com.farm.app.renter.repository.RenterRepository;
import com.farm.app.renter.service.RenterService;
import com.farm.app.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Service
public class RenterServiceImpl implements RenterService {

    private final RenterRepository renterRepository;

    @Autowired
    public RenterServiceImpl(RenterRepository renterRepository) {

        this.renterRepository = renterRepository;
    }

    @Override
    public RenterDto save(RenterDto renterDto) {
//        // 1. Convert DTO to Entity
//        Renter renter = new Renter();
//        renter.setName(renterDto.getName());
//        renter.setEmail(renterDto.getEmail());
//        renter.setPhone(renterDto.getPhone());
//        renter.setPassword(renterDto.getPassword());
//        renter.setAddress(renterDto.getAddress());

        try {
            Renter renter = MapperUtility.sourceToTarget(renterDto, Renter.class);
            renter = renterRepository.saveAndFlush(renter);
            return MapperUtility.sourceToTarget(renter, RenterDto.class);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


//        // 2. Save the Entity using the Repository
//        Renter savedRenter = renterRepository.save(renter);
//
//        // 3. Convert the saved Entity back to a DTO (if the return type is a DTO)
//        RenterDto renterDto1 = new RenterDto();
//        renterDto1.setId(savedRenter.getId());
//        renterDto1.setName(renterDto.getName());
//        renterDto1.setEmail(renterDto.getEmail());
//        renterDto1.setPhone(renterDto.getPhone());
//        renterDto1.setPassword(renterDto.getPassword());
//        renterDto1.setAddress(renterDto.getAddress());
//
//        return renterDto1;
    }

    @Override
    public RenterDto getRenterById(int id) {
        Renter renter = renterRepository.findById(id).orElseThrow();

        try {
            return MapperUtility.sourceToTarget(renter, RenterDto.class);
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
    public List<RenterDto> allRenters() {
// Fetch all renters from the database
        List<Renter> renterList = renterRepository.findAll();

        // Convert Entities to DTOs
        return renterList.stream().map(renter -> {
            try {
                return MapperUtility.sourceToTarget(renter, RenterDto.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    @Override
    public RenterDto update(RenterDto renterDto, int id) {
        Renter renter = renterRepository.findById(id).orElseThrow();
        renter.setName(renterDto.getName());
        renter.setEmail(renterDto.getEmail());
        renter.setPhone(renterDto.getPhone());
        renter.setPassword(renterDto.getPassword());
        renter = renterRepository.saveAndFlush(renter);

        try {
            return MapperUtility.sourceToTarget(renter, RenterDto.class);
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
        renterRepository.deleteById(id);

    }
}
