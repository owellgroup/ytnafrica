package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.admin.ArtistPayments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistPaymentsRepository extends JpaRepository<ArtistPayments, UUID> {
}