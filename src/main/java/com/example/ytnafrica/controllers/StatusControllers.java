package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Status;
import com.example.ytnafrica.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusControllers {
    @Autowired
    private StatusService statusrepo;


    //posting maping
    @PostMapping("/post")
    public Status postStatus(@RequestBody Status status){
        return statusrepo.saveStatus(status);
    }

    //get all status
    @GetMapping("/all")
    public List<Status> findAllStatus(){
        return statusrepo.findAllStatus();
    }

    @GetMapping("{id}")
    public Optional<Status> findStatusById(@PathVariable Long id){
        return statusrepo.findStatusById(id);
    }
    @PutMapping("/update/{id}")
    public Status updateStatus(@RequestBody Status status, @PathVariable Long id){
        status.setId(id);
        return statusrepo.saveStatus(status);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStatus(@PathVariable Long id){
        statusrepo.deleteStatusById(id);
    }
}
