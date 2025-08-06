package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Status;
import com.example.ytnafrica.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusrepo;

    //post
    public Status saveStatus(Status status){
        return statusrepo.save(status);
    }
    //get all
    public List<Status> findAllStatus(){
        return statusrepo.findAll();
    }
    //get  by id
    public Optional<Status> findStatusById(Long id){
        return statusrepo.findById(id);
    }
    //update
    public Status updateStatus(Status status){
        Status updatedStatus = statusrepo.findById(status.getId()).orElse(null);
        updatedStatus.setStatusName(status.getStatusName());
        return statusrepo.save(updatedStatus);
    }
    //deleting
   public void deleteStatusById(Long id){
        statusrepo.deleteById(id);
   }

}
