package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.MediaFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaFilesRepository extends JpaRepository<MediaFiles, Long> {
    Long id(Long id);
}