package com.example.ytnafrica.services;

import com.example.ytnafrica.models.DocumentsCategory;
import com.example.ytnafrica.models.Gender;
import com.example.ytnafrica.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {
    @Autowired
    private GenderRepository genderRepository;

    //posting
    public Gender saveGender(Gender gender) {
        return genderRepository.save(gender);
    }
    //get all
    public List<Gender> getGenders() {
        return genderRepository.findAll();
    }

    //get by Id
    public Optional<Gender> getGenderById(long id) {
        return genderRepository.findById(id);
    }
    //updating
    public Gender updateDocCat(Gender genderr) {
        Gender gender = genderRepository.findById(genderr.getId()).orElse(null);
        gender.setGenderName(genderr.getGenderName());
        return genderRepository.save(gender);
    }

    //deleting
    public void deleteGender(long id) {
        genderRepository.deleteById(id);
    }


}
