package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.admin.OrginCompanybankDetaills;
import com.example.ytnafrica.services.OrginComBankDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orginalbankdetails")
public class OrginComDbankController {
    @Autowired
    private OrginComBankDService service;

    //post
    @PostMapping("/post")
    public OrginCompanybankDetaills post(@RequestBody OrginCompanybankDetaills details){
        return service.saveCompanybankDetaills(details);
    }

    //get all
    @GetMapping("/all")
    public List<OrginCompanybankDetaills> getAll(){
        return service.findAllCompanybankDetaills();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<OrginCompanybankDetaills> getOne(@PathVariable long id){
        return service.findCompanybankDetaills(id);
    }

    //update
    @PutMapping("/update/{id}")
    public OrginCompanybankDetaills update(@RequestBody OrginCompanybankDetaills details, @PathVariable long id){
       details.setId(id);
       return service.updateCompanybankDetaills(details);
    }

    //deleting
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        service.deleteCompanybankDetaills(id);
    }

}
