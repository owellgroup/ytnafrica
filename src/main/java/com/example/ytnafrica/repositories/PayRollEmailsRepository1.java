package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.admin.PayRollEmails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PayRollEmailsRepository1 extends JpaRepository<PayRollEmails, UUID> {
}