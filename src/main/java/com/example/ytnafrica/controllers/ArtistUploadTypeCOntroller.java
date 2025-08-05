package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.ArtistUploadType;
import com.example.ytnafrica.services.ArtistUploadTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ArtistUploadType")
public class ArtistUploadTypeCOntroller {
    @Autowired
    private ArtistUploadTypeService artUploadTypeService;

    //post mapping
    @PostMapping("/post")
    public ArtistUploadType post(@RequestBody ArtistUploadType artistUploadType) {
        return artUploadTypeService.saveUploadType(artistUploadType);
    }

    //get mapping
    @GetMapping("/all")
    public List<ArtistUploadType> getAllArtistUploadType() {
        return artUploadTypeService.findAllArtistType();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<ArtistUploadType> getArtistUploadTypeById(@PathVariable Long id) {
        return artUploadTypeService.findArtistTypeById(id);

    }
    //delete method
    @DeleteMapping("/delete/{id}")
    public void  deleteArtistUploadTypeById(@PathVariable Long id) {
        ArtistUploadType art = artUploadTypeService.findArtistTypeById(id).orElse(null);
        artUploadTypeService.deleteArtistTypeById(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public ArtistUploadType updateArtistUploadType(@RequestBody ArtistUploadType artistUploadType, @PathVariable Long id) {
        artistUploadType.setId(id);
        return artUploadTypeService.UpdateArtistUploadType(artistUploadType);
    }
}
