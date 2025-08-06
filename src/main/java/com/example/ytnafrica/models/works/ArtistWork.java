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
    private String AlbumName;//ignore if you are releasing single
    private String NameOfGroupOrBandOrStageName;
    private String ContactNumber;
    private String titleOfWork;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistUploadType_id")
    private ArtistUploadType artistUploadType;// video/mp3
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistWorkType_id")
    private ArtistWorkType artistWorkType;//pop, jazz, e.t.c
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
    @ManyToOne
    @JoinColumn(name="MediaFiles_id")
    private MediaFiles mediaFiles;
    @ManyToOne
    @JoinColumn(name="IPI_id")
    private IPI IPI_For_Each_Work;
    //
    @ManyToOne
    @JoinColumn(name="CopyRight_id")
    private CopyRights copyRights;
    //generate copyrights

    //add artist details for admins like Id or names
   //user details for role base
}
