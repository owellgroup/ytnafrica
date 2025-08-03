package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}