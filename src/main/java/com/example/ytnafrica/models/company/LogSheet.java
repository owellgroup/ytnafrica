package com.example.ytnafrica.models.company;

import com.example.ytnafrica.models.ArtistUploadType;
import com.example.ytnafrica.models.works.ArtistWork;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LogSheet")
public class LogSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String LogSheetName;
    private String LogSheetDescription;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistUploadType_Id")
    private ArtistUploadType LogSheetType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistWork_Id")
    private ArtistWork artistWork;
}
