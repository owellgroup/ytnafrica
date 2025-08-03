package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.works.ArtistWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistWorkRepository extends JpaRepository<ArtistWork, UUID> {
}