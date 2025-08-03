package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.company.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Long> {
}