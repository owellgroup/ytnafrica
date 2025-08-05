package com.example.ytnafrica.services;

import com.example.ytnafrica.models.LicenseBy;
import com.example.ytnafrica.repositories.LicenseByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseByService {
    @Autowired
    private LicenseByRepository license;

    //posting
    public LicenseBy saveLicenseBy(LicenseBy licenseBy) {
        return license.save(licenseBy);
    }

    //get all method
    public List<LicenseBy> getAllLicenseBy() {
        return license.findAll();
    }
    //get by Id
    public Optional<LicenseBy> getLicenseBy(long id) {
        return license.findById(id);
    }

    //deleting
    public void deleteLicenseBy(long id) {
        license.deleteById(id);
    }
    //updating
    public LicenseBy updateLicenseBy(LicenseBy licenseBy) {
        LicenseBy updatedLicenseBy = license.findById(licenseBy.getId()).orElse(null);
        updatedLicenseBy.setLicenseByWho(licenseBy.getLicenseByWho());
        return license.save(updatedLicenseBy);
    }
}
