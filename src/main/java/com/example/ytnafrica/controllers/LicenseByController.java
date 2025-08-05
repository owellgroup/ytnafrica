package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.LicenseBy;
import com.example.ytnafrica.services.LicenseByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/licenseby")
public class LicenseByController {
    @Autowired
    private LicenseByService licenseByService;

    //post mappping
    @PostMapping("/post")
    public LicenseBy saveLicenseByPost(LicenseBy licenseBy) {
        return licenseByService.saveLicenseBy(licenseBy);
    }

    //get method
    @GetMapping("/all")
    public List<LicenseBy> getAllLicenseBy() {
        return licenseByService.getAllLicenseBy();

    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<LicenseBy> getLicenseBy(@PathVariable long id) {
        return licenseByService.getLicenseBy(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public LicenseBy updateLicenseBy(@PathVariable long id, @RequestBody LicenseBy licenseBy) {
        licenseBy.setId(id);
        return licenseByService.updateLicenseBy(licenseBy);
    }
    //deleting
    @DeleteMapping("/{id}")
    public void deleteLicenseBy(@PathVariable long id) {
        licenseByService.deleteLicenseBy(id);
    }
}
