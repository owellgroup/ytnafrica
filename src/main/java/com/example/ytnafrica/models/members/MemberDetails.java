package com.example.ytnafrica.models.members;

import com.example.ytnafrica.models.*;
import com.example.ytnafrica.models.works.ArtistWork;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="members")
public class MemberDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Title_id")
    private Tittle title;
    //
    @Column(unique = true)
    private String MemberID;
    //
    @Column(nullable=false)
    private String FirstName;
    @Column(nullable=false)
    private String Surname;
    private String Pseudonym;
    @Column(nullable=false)
    private String PhoneNumber;
    @Column(unique = true)
    private String Email;
    private String GroupNameORStageName;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaritalStatus_id")
    private MaritalStatus MaritalStatus;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MemberCategory_id")
    private MemberCategory MemberCategory; //composer/Author/Arranger
    //
    private int NoOFDependents;
    //
    private String TypeOfWork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name= "Gender_id")
    private Gender Gender;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Address_id")
    private Address Address;
    //
    private LocalDate BirthDate;
    //
    private String PlaceOfBirth;
    //
    private String IdOrPassportNumber;
    //
    private String Nationality;
    //
    private String Ocupation;
    //
    private String NameOfEmployer;
    private String AddressOfEmployer;
    //
    private String NameOfTheBand;

    private LocalDate dateFounded;
    private int numberOfband;
    //attaching bank details to the form
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="BankDetails_id", nullable=false)
    private BankDetails BankDetails;

    //
    // attaching Documents
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Documents_id", nullable=false)
    private Documents documents;
    //
     //attching proof of payments
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ProofOfPayments_id", nullable=false)
    private ProofOfPayments ProofOfPayments;
    //
     //attaching passport
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PassportPhoto_id")
    private PassportPhoto passportPhoto;

    //
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistWork_id")
    private ArtistWork artistWork;

     //
    //
    //attaching status
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Status_id")
    private Status status;
    //
     //attaching notes
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Note_id")
    private Note notes;
    //attaching IPI
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IPI_id")
    private IPI IPI;



}
