package com.iraqsofit.speedoo.service;


import com.iraqsofit.speedoo.models.AddressInfo;
import com.iraqsofit.speedoo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServer {
    @Autowired
    private AddressRepository addressRepository;


    public List<AddressInfo> getAddressByUserID(String username){
        return addressRepository.findAllByUsername(username);
    }


    public AddressInfo save(AddressInfo address){
        return addressRepository.save(address);
    }



}
