package com.example.ytnafrica.services;

import com.example.ytnafrica.models.ArtistUploadType;
import com.example.ytnafrica.repositories.ArtistUploadTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistUploadTypeService {
    @Autowired
    private ArtistUploadTypeRepository artUploadTypeRepo;

    //saving the file
    public ArtistUploadType saveUploadType (ArtistUploadType artistUploadType){
        return artUploadTypeRepo.save(artistUploadType);
    }

    // get all ArtistUploadType
    public List<ArtistUploadType> findAllArtistType(){
        return artUploadTypeRepo.findAll();
    }
    //
    public Optional<ArtistUploadType> findArtistTypeById(long id){
        return artUploadTypeRepo.findById(id);
    }

    //deleting  method
    public void deleteArtistTypeById(long id){
        artUploadTypeRepo.deleteById(id);
    }

    //updating
    public ArtistUploadType UpdateArtistUploadType(ArtistUploadType uploadType){
        ArtistUploadType newupload = artUploadTypeRepo.findById(uploadType.getId()).orElse(null);
        newupload.setWorkUploadType(uploadType.getWorkUploadType());
        return artUploadTypeRepo.save(newupload);

    }

}
