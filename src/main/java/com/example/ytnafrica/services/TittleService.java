package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Tittle;
import com.example.ytnafrica.repositories.TittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TittleService {
    @Autowired
    private TittleRepository tittleRepository;

    //posting
    public Tittle saveTitle(Tittle tittle) {
        return tittleRepository.save(tittle);
    }
    //get all
    public List<Tittle> findAllTittle() {
        return tittleRepository.findAll();
    }

    //get by Id
    public Optional<Tittle> findTittleById(Long id) {
        return tittleRepository.findById(id);
    }

    //upadting
    public Tittle updateTitle(Tittle tittle) {
        Tittle updatedTittle = tittleRepository.findById(tittle.getId()).get();
        updatedTittle.setTittleName(tittle.getTittleName());
        return tittleRepository.save(updatedTittle);
    }
    //deleting
    public void deleteTitle(Long id) {
        tittleRepository.deleteById(id);
    }
}
