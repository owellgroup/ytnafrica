package com.example.ytnafrica.models;

import com.example.ytnafrica.models.members.MemberDetails;
import com.example.ytnafrica.models.works.ArtistWork;
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
    private String CopyRightsId;
    //

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MembersDetails_id")
    //get thier names, emails or phone numbers etc also the membersID
    private MemberDetails MemberDetails;
    //get artist work details
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistWork_id")
    private ArtistWork ArtistWork;
    //get license by with get method
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LicenseBy_Id")
    private LicenseBy licenseBy;
    private LocalDate copyrightDate;
}
