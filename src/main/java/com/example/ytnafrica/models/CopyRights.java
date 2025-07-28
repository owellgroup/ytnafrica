package com.example.ytnafrica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CopyRights")
public class CopyRights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String copyrightHolder;
    private String composer;
    private String producer;
    private String label;
    private String rights_registered_with; //NASCAM
    private String MemberID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="License_Type_Id")
    private License_Type license_type;
    private LocalDate copyrightDate;
}
