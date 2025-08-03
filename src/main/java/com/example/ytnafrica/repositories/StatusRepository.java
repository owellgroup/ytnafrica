package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}