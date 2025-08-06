package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.MaritalStatus;
import com.example.ytnafrica.services.MaritalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maritalstatus")
public class MaritalStatusController {
    @Autowired
    private MaritalStatusService maritalStats;

    //post maping
    @PostMapping("/post")
    public MaritalStatus saveMaritalStatus(@RequestBody MaritalStatus maritalStatus){
        return maritalStats.saveMaritalStatus(maritalStatus);
    }

    //get all
    @GetMapping("/all")
    public List<MaritalStatus> getAllMaritalStatus(){
        return maritalStats.getAllMaritalStatus();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<MaritalStatus> getMaritalStatus(@PathVariable Long id){
        return maritalStats.getMaritalStatusById(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public MaritalStatus updateMaritalStatus(@RequestBody MaritalStatus maritalStatus, @PathVariable Long id){
         maritalStatus.setId(id);
         return maritalStats.saveMaritalStatus(maritalStatus);
    }

    //deleting
    @DeleteMapping("/delete/{id}")
    public void deleteMaritalStatus(@PathVariable Long id){
        maritalStats.deleteMaritalStatus(id);
    }
}
