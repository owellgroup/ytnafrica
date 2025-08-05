package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.License_Type;
import com.example.ytnafrica.services.LicenceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/license")
public class LicenseTypeController {
    @Autowired
    private LicenceTypeService liceService;

    //Posting
    @PostMapping
    public License_Type addLicenseType(@RequestBody License_Type license_type) {
        return liceService.saveLicence(license_type);
    }
    //get all
    @GetMapping
    public List<License_Type> getAllLicenseType() {
        return liceService.getLicenceTypes();
    }

    //get by id
    @GetMapping("/{id}")
    public Optional<License_Type> getLicenseType(@PathVariable long id) {
        return liceService.getLicenseById(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public License_Type updateLicenseType(@RequestBody License_Type licensetp, @PathVariable long id) {
        licensetp.setId(id);
        return liceService.updateLicense(licensetp);

    }

    //deleteing
    @DeleteMapping("/delete/{id}")
    public void deleteLicenseType(@PathVariable long id) {
        liceService.deleteLicense(id);
    }
}
