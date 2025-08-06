package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.admin.PayRollEmails;
import com.example.ytnafrica.services.PayRollsEmailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/payrollemails")
public class PayRollEmailController {
    @Autowired
    private PayRollsEmailsService service;

    //post maping
    @PostMapping("/post")
    public PayRollEmails post(@RequestBody PayRollEmails payRollEmails){
        return service.ceateEmail(payRollEmails);

    }

    //get al
    @GetMapping("/all")
    public List<PayRollEmails> getAll(){
        return service.getPayRollEmails();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<PayRollEmails> getPayRollEmails(@PathVariable UUID id){
        return service.getPayRollEmail(id);

    }

    //updating
    @PutMapping("/update/{id}")
    public PayRollEmails updating(@PathVariable UUID id, @RequestBody PayRollEmails payRollEmails){
        payRollEmails.setId(id);
        return service.updatePayRollEmail(payRollEmails);
    }

    //deleting
    @DeleteMapping("/delete/{id}")
    public void deletePayRollEmails(@PathVariable UUID id){
        service.deletedById(id);
    }

}
