package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Address;
import com.example.ytnafrica.services.AddressService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Address")

public class AddressController {
    @Autowired
    private AddressService addressService;
    //post mapping
    @PostMapping
    public Address postAddress (@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    // get method get all
    @GetMapping("/all")
    public List<Address> getAddress () {
        return addressService.getAllAddresses();
    }
    //get Adress by its ID number
    @GetMapping("/{id}")
    public Optional<Address> getAddressById (@PathVariable long  id) {
        return addressService.getAddressById(id);
    }
    //update method
    @PutMapping("/update/{id}")
    public Address updateAddress (@RequestBody Address address, @PathVariable long id) {
        address.setId(id);
        return addressService.UpdateAddress(address);
    }
    //delete method
    @DeleteMapping("/delete/{id}")
    public void deleteAddressById (@PathVariable long  id) {
     Address address = addressService.getAddressById(id).orElse(null);
     addressService.deleteAddressById(id);
    }

}
