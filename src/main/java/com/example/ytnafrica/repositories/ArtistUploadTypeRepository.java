package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.ArtistUploadType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistUploadTypeRepository extends JpaRepository<ArtistUploadType, Long> {
    List<ArtistUploadType> id(Long id);
}