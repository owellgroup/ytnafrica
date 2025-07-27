package com.example.ytnafrica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String StatusName;
}
