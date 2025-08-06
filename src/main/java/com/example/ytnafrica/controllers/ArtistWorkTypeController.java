package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.ArtistUploadType;
import com.example.ytnafrica.models.ArtistWorkType;
import com.example.ytnafrica.services.ArtsitWorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ArtistWorkType")
public class ArtistWorkTypeController {
    @Autowired
    private ArtsitWorkTypeService artservice;

    //Post mapping method
    @PostMapping("/post")
    public ArtistWorkType post(@RequestBody ArtistWorkType artistUploadType) {
        return artservice.saveWorkType(artistUploadType);

    }

    //get mapping
    @GetMapping("/all")
    public List<ArtistWorkType> getAllArtistWorkType() {
        return artservice.AllWorkType();
    }

    //find by Id
    @GetMapping("/{id}")
    public Optional<ArtistWorkType> getArtistWorkType(@PathVariable Long id) {
        return artservice.WorkTypeById(id);
    }

    //Deleting Controller
    @DeleteMapping("/delete/{id}")
    public void deleteArtistWorkType(@PathVariable Long id) {
        artservice.deleteWorkType(id);
    }

    //Put maping or Udating
    @PutMapping("/update/{id}")
    public ArtistWorkType update(@PathVariable Long id, @RequestBody ArtistWorkType artistW) {
        artistW.setId(id);
        return artservice.updateWorkType(artistW);
    }
}
