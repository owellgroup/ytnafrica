package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Address;
import com.example.ytnafrica.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;


    //saving address
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}
