package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.admin.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentsRepository extends JpaRepository<Payments, UUID> {
}