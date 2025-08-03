package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.admin.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoicesRepository extends JpaRepository<Invoices, UUID> {
}