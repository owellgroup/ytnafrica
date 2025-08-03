package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Address;
import com.example.ytnafrica.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;


    //saving address
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    //get methods
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
    //find by Id
    public Optional<Address> getAddressById(Long addressId) {
        return addressRepository.findById(addressId);
    }
    // update method
    public Address UpdateAddress(Address address){
        Address newAddress = addressRepository.findById(address.getId()).orElse(null);
        newAddress.setCity(address.getCity());
        newAddress.setCountry(address.getCountry());
        newAddress.setLine1(address.getLine1());
        newAddress.setLine2(address.getLine2());
        newAddress.setPOBOX(address.getPOBOX());
        newAddress.setPostal_code(address.getPostal_code());
        newAddress.setRegion(address.getRegion());
        return addressRepository.save(newAddress);

    }

    //delete method
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }
}
