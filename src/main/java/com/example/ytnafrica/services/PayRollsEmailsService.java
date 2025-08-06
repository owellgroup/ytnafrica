package com.example.ytnafrica.services;

import com.example.ytnafrica.models.admin.PayRollEmails;
import com.example.ytnafrica.repositories.PayRollEmailsRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PayRollsEmailsService {
    @Autowired
    private PayRollEmailsRepository1 payRol;

    //post
    public PayRollEmails ceateEmail (PayRollEmails payRollEmails){
        return payRol.save(payRollEmails);
    }

    //get all
    public List<PayRollEmails> getPayRollEmails(){
        return payRol.findAll();
    }

    //get by Id
    public Optional<PayRollEmails> getPayRollEmail(UUID id){
        return payRol.findById(id);
    }

    //update
    public PayRollEmails updatePayRollEmail(PayRollEmails payRollEmails){
        PayRollEmails newp = payRol.findById(payRollEmails.getId()).orElse(null);
        newp.setEmail(payRollEmails.getEmail());
        return payRol.save(payRollEmails);
    }

    //delete
    public void deletedById (UUID id){
        payRol.deleteById(id);
    }
}
