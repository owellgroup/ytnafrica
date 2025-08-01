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
@Table(name="MediaFiles")
public class MediaFiles {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    private String fileName;
    private String fileUrl;
    private String fileType;

    //attaching lyrics
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Lyrics_id")
    private Lyrics lyrics;
    //e.g mp3/Audio
    private LocalDate fileDatePosted;
}
