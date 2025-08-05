package com.example.ytnafrica.services;

import com.example.ytnafrica.models.ArtistUploadType;
import com.example.ytnafrica.models.ArtistWorkType;
import com.example.ytnafrica.repositories.ArtistWorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtsitWorkTypeService {
    @Autowired
    private ArtistWorkTypeRepository TypeRepo;

    //Post method
    public ArtistWorkType saveWorkType(ArtistWorkType artistWorkType){
        return TypeRepo.save(artistWorkType);
    }

    //get method
    public List<ArtistWorkType> AllWorkType(){
        return TypeRepo.findAll();
    }

    //find by Id
    public Optional<ArtistWorkType> WorkTypeById(long id){
        return TypeRepo.findById(id);

    }

    //updating
    public ArtistWorkType updateWorkType(ArtistWorkType artistWorkType){
        ArtistWorkType updated = TypeRepo.findById(artistWorkType.getId()).orElse(null);
        updated.setWorkType(artistWorkType.getWorkType());
        return TypeRepo.save(updated);
    }
    public void deleteWorkType(long id){
        TypeRepo.deleteById(id);
    }


}
