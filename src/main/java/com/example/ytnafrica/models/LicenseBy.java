package com.example.ytnafrica.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LicenseBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //e.g nascam
    private String licenseBy;
}
