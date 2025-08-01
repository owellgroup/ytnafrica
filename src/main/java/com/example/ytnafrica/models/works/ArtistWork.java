package com.example.ytnafrica.models.works;

import com.example.ytnafrica.models.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ArtistWork")
public class ArtistWork {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String AlbumName;
    private String NameOfGroupOrBandOrStageName;
    private String ContactNumber;
    private String titleOfWork;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistUploadType_Id")
    private ArtistUploadType artistUploadType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistWorkType_Id")
    private ArtistWorkType artistWorkType;
    private String Duration;
    @Column(nullable=false)
    private String Composer;
    @Column(nullable=false)
    private String Author;
    @Column(nullable=false)
    private String Publisher;
    @Column(nullable=false)
    private String PublisherName;
    private String PublisherAddress;
    private String PublisherPhone;
    private String PublisherEmail;
    private String RecordedBy;
    private String RecordingCompanyAddress;
    private String RecordingCompanyPhoneNumber;
    private String RecordingCompanyEmail;
    private String LabelName;
    private LocalDate RecordingDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MediaFiles_Id")
    private MediaFiles mediaFiles;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IPI_Id")
    private IPI IPI_For_Each_Work;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Lincense_Type_Id")
    private License_Type License_Type;
}
