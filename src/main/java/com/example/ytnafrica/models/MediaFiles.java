package com.example.ytnafrica.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MediaFiles")
public class MediaFiles {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String MediafileName;
    private String fileUrl;
    private String fileType;


    private String lyrics;
    //e.g mp3/Audio
    private LocalDate fileDatePosted;
}
