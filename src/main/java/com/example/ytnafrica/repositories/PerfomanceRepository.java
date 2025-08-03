package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.admin.Perfomance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PerfomanceRepository extends JpaRepository<Perfomance, UUID> {
}