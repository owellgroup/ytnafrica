package com.example.ytnafrica.services;

import com.example.ytnafrica.models.RecordingMembers;
import com.example.ytnafrica.repositories.RecordingMembersRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordingMembersService {
    @Autowired
    private RecordingMembersRepository recordingMemberrepo;

    //post
    public RecordingMembers saveRecordingMembers(RecordingMembers recordingMembers){
        return recordingMemberrepo.save(recordingMembers);
    }

    //get all
    public List<RecordingMembers> findAllRecordingMembers(){
        return recordingMemberrepo.findAll();
    }

    //get by Id
    public Optional<RecordingMembers> findRecordingMembersById(long id){
        return recordingMemberrepo.findById(id);
    }

    //update
    public RecordingMembers updateRecordingMembers(RecordingMembers recordingMembers){
        RecordingMembers newRecordingMembers = recordingMemberrepo.findById(recordingMembers.getId()).orElse(null);
        newRecordingMembers.setRecordingMemberName(recordingMembers.getRecordingMemberName());
        return recordingMemberrepo.save(newRecordingMembers);
    }

    //deleting
    public void deleteRecordingMembersById(long id){
        recordingMemberrepo.deleteById(id);
    }
}
