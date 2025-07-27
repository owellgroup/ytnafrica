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
@Table(name="documents")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String title;
    private String fileType;
    private String fileUrl;
    private LocalDate dateposted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="documentsCategoory_id", nullable=false)
    private DocumentsCategory documentsCategory;

}
