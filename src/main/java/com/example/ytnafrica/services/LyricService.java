package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Lyrics;
import com.example.ytnafrica.repositories.LyricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LyricService {
    @Autowired
    private LyricsRepository lyricsRepository;

    //post
    public Lyrics saveLyrics(Lyrics lyrics){
        return lyricsRepository.save(lyrics);
    }
    //get all
    public List<Lyrics> findAllLyrics(){
        return lyricsRepository.findAll();
    }

    //get by Id
    public Optional<Lyrics> findLyricsById(long id){
        return lyricsRepository.findById(id);
    }

    //update
    public Lyrics updateLyrics(Lyrics lyrics){
        Lyrics updatedLyrics = lyricsRepository.findById(lyrics.getId()).orElse(null);
        updatedLyrics.setContentTile(lyrics.getContentTile());
        updatedLyrics.setLyric(lyrics.getLyric());
        return lyricsRepository.save(updatedLyrics);
    }

    //deleteing
    public void deleteLyricsById(Long id){
        lyricsRepository.deleteById(id);
    }
}
