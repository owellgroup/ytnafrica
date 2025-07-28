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
@Table(name="members")
public class MemberDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    private String MemberID;
    @Column(nullable=false)
    private String FirstName;
    @Column(nullable=false)
    private String Surname;
    private String Pseudonym;
    @Column(nullable=false)
    private String PhoneNumber;
    @Column(nullable=false)
    private String Email;
    private String GroupNameORStageName;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MaritalStatus_Id")
    private MaritalStatus MaritalStatus;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MemberCategory_Id")
    private MemberCategory MemberCategory;
    //
    private int NoOFDependents;
    //
    private String TypeOfWork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name= "Gender_Id")
    private Gender Gender;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Address_Id")
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
    @JoinColumn (name="BankDetails_Id")
    private BankDetails BankDetails;

    //
     // attaching Documents
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Documents_Id")
    private Documents documents;
    //
     //attching proof of payments
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ProofOfPayments_Id")
    private ProofOfPayments ProofOfPayments;
    //
     //attaching passport
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PassportPhoto_Id")
    private PassportPhoto passportPhoto;

    //
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistWork_Id")
    private ArtistWork artistWork;

     //
    //
    //attaching status
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Status_Id")
    private Status status;
    //
     //attaching notes
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Note_Id")
    private Note notes;
    //attaching IPI
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IPI_Id")
    private IPI IPI;



}
