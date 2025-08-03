package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
}