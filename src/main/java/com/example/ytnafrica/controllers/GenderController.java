package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Gender;
import com.example.ytnafrica.repositories.GenderRepository;
import com.example.ytnafrica.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    private GenderService genderService;

    //Post maping
    @PostMapping("/post")
    public Gender createGender(@RequestBody Gender gender) {
        return genderService.saveGender(gender);
    }
    //get all
    @GetMapping("/all")
    public List<Gender> getAllGenders() {
        return genderService.getGenders();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<Gender> getIdGender(Long id) {
        return  genderService.getGenderById(id);
    }

    //Delete
    @DeleteMapping("/delete")
    public void deleteGender(Long id) {
        genderService.deleteGender(id);
    }

    //Updating
    @PutMapping("/update/{id}")
    public Gender updateGender(@RequestBody Gender gender, @PathVariable Long id) {
        gender.setId(id);
        return genderService.saveGender(gender);
    }

}
