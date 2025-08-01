package com.example.ytnafrica.models.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PayRollEmails {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    private String email;
}
