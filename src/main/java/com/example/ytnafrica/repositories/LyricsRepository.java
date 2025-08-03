package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LyricsRepository extends JpaRepository<Lyrics, Long> {
}