package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.admin.OriginCompanyDetails;
import com.example.ytnafrica.services.OriginCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/originalcompanydetails")
public class OriginComDeController {
    @Autowired
    private OriginCompanyService service;

    //post
    @PostMapping("/post")
    public OriginCompanyDetails create(@RequestBody OriginCompanyDetails originCompanyDetails){
        return service.createOrgin(originCompanyDetails);

    }

    //get all
    @GetMapping("/all")
    public List<OriginCompanyDetails> getAll(){
        return service.findAll();
    }
    //get by id
    @GetMapping("/{id}")
    public Optional<OriginCompanyDetails> getOne(@PathVariable Long id){
        return service.getById(id);
    }

    //update
    @PutMapping("/update/{id}")
    public OriginCompanyDetails update(@PathVariable Long id, @RequestBody OriginCompanyDetails originCamp){
        originCamp.setId(id);
        return service.update(originCamp);

    }

    //delete
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}
