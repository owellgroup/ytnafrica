package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Lyrics;
import com.example.ytnafrica.services.LyricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/lyrics")
@RestController
public class LyricsController {
    @Autowired
    private LyricService lyricService;


    //Post maping
    @PostMapping("/post")
    public Lyrics postLyrics(Lyrics lyrics){
        return lyricService.saveLyrics(lyrics);
    }

    //get maping
    @GetMapping("/all")
    public List<Lyrics> getAllLyrics(){
        return lyricService.findAllLyrics();
    }

    @GetMapping("/{id}")
    public Optional<Lyrics> getLyrics(@PathVariable Long id){
        return lyricService.findLyricsById(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public Lyrics updateLyrics(Lyrics lyrics, @PathVariable long id){
        lyrics.setId(id);
        return lyricService.updateLyrics(lyrics);
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public void deleteLyrics(@PathVariable Long id){
        lyricService.deleteLyricsById(id);
    }

}
