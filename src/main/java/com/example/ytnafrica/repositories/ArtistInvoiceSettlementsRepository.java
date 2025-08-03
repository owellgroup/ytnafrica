package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.admin.ArtistInvoiceSettlements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistInvoiceSettlementsRepository extends JpaRepository<ArtistInvoiceSettlements, UUID> {
}