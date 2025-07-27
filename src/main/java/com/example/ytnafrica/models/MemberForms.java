package com.example.ytnafrica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="members")
public class MemberForms {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    private String firstname;
    private String lastname;
}
