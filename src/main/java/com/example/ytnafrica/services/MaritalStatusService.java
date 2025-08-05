package com.example.ytnafrica.services;

import com.example.ytnafrica.models.MaritalStatus;
import com.example.ytnafrica.repositories.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaritalStatusService {
    @Autowired
    private MaritalStatusRepository maritalrepo;

    //posting
    public MaritalStatus saveMaritalStatus(MaritalStatus maritalstatus){
        return maritalrepo.save(maritalstatus);
    }

    //get all
    public List<MaritalStatus> getAllMaritalStatus(){
        return maritalrepo.findAll();
    }

    //get by ID
    public Optional<MaritalStatus> getMaritalStatusById(long id){
        return maritalrepo.findById(id);
    }

    //updating
    public MaritalStatus updateMaritalStatus(MaritalStatus maritalstatus){
        MaritalStatus updatedMaritalStatus = maritalrepo.findById(maritalstatus.getId()).orElse(null);
        updatedMaritalStatus.setMaritalStatus(maritalstatus.getMaritalStatus());
        return maritalrepo.save(updatedMaritalStatus);
    }

    //deleteing
    public void deleteMaritalStatus(long id){
        maritalrepo.deleteById(id);
    }
}
