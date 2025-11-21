package com.farm.app.owner.service.impl;

import com.farm.app.owner.dto.OwnerDto;
import com.farm.app.owner.entity.Owner;
import com.farm.app.owner.repository.OwnerRepository;
import com.farm.app.owner.service.OwnerService;
import com.farm.app.utility.MapperUtility;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;


    @Override
    public OwnerDto save(OwnerDto ownerDto) {
        try {
            Owner owner = MapperUtility.sourceToTarget(ownerDto, Owner.class);
            owner = this.ownerRepository.saveAndFlush(owner);
            return MapperUtility.sourceToTarget(owner,OwnerDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OwnerDto> getAllOwner() {
        List<Owner> all = this.ownerRepository.findAll();
        return all.stream().map(owner -> {
            try {
                return MapperUtility.sourceToTarget(owner ,OwnerDto.class);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    @Override
    public OwnerDto update(OwnerDto ownerDto, int id) {
        Owner owner = this.ownerRepository.findById(id).orElseThrow();
        owner.setName(ownerDto.getName());
        owner.setEmail(ownerDto.getEmail());
        owner.setPhone(ownerDto.getPhone());
        owner=this.ownerRepository.saveAndFlush(owner);
        try {
            return MapperUtility.sourceToTarget(owner,OwnerDto.class);
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
}
