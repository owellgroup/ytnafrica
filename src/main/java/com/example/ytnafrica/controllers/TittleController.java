package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Tittle;
import com.example.ytnafrica.repositories.TittleRepository;
import com.example.ytnafrica.services.TittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tittle")
public class TittleController {
    @Autowired
    private TittleService tittleService;

    //post
    @PostMapping("/post")
    public Tittle postTittle(@RequestBody Tittle tittle) {
        return tittleService.saveTitle(tittle);
    }

    //get
    @GetMapping("/all")
    public List<Tittle> getAllTittle() {
        return tittleService.findAllTittle();

    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<Tittle> findTittleById(@PathVariable int id) {
        return tittleService.findTittleById(id);
    }

    //update
    @PutMapping("/update/{id}")
    public Tittle updateTittle(@PathVariable int id, @RequestBody Tittle tittle) {
        tittle.setId(id);
        return tittleService.saveTitle(tittle);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public void deleteTittle(@PathVariable int id) {

    }
}
