package com.example.ytnafrica.services;

import com.example.ytnafrica.models.IPI;
import com.example.ytnafrica.models.License_Type;
import com.example.ytnafrica.repositories.License_TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenceTypeService {
    @Autowired
    private License_TypeRepository LtypeRepository;

    //posting
    public License_Type saveLicence(License_Type lice) {
        return LtypeRepository.save(lice);
    }
    //get all
    public List<License_Type> getLicenceTypes() {
        return LtypeRepository.findAll();
    }

    //get by Id
    public Optional<License_Type> getLicenseTypeById(long id) {
        return LtypeRepository.findById(id);
    }
    //updating
    public License_Type updateLicense(License_Type lises) {
        License_Type lices = LtypeRepository.findById(lises.getId()).orElse(null);
        lices.setId(lises.getId());
        return LtypeRepository.save(lices);
    }

    //deleting
    public void deleteLicense(long id) {
        LtypeRepository.deleteById(id);
    }

}
