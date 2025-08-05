package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.RecordingMembers;
import com.example.ytnafrica.services.RecordingMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recordingmembers")
public class RecordingMembersController {
    @Autowired
    private RecordingMembersService recordingMservice;

    //posting
    @PostMapping("/post")
    public RecordingMembers postRecordingMembers(@RequestBody RecordingMembers recordingMembers){
        return recordingMservice.saveRecordingMembers(recordingMembers);
    }

    //get all
    @GetMapping("/all")
    public List<RecordingMembers> getAllRecordingMembers(){
        return recordingMservice.findAllRecordingMembers();
    }

    //get by by
    @GetMapping("/{id}")
    public Optional<RecordingMembers> getRecordingMembers(@PathVariable long id){
        return recordingMservice.findRecordingMembersById(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public RecordingMembers updateMembers(@RequestBody RecordingMembers recordingMembers, @PathVariable long id){
        recordingMembers.setId(id);
        return recordingMservice.saveRecordingMembers(recordingMembers);
    }

    //deleteing
    @DeleteMapping("/deletinng/{id}")
    public void deleteMembers(@PathVariable long id){
        recordingMservice.deleteRecordingMembersById(id);
    }
}
