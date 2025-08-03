package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Address;
import com.example.ytnafrica.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
