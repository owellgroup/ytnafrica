package com.example.ytnafrica.models.members;

import com.example.ytnafrica.models.Address;
import com.example.ytnafrica.models.BankDetails;
import com.example.ytnafrica.models.recordingmembers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="recordingcompanies")
public class recordingcompanydetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    private String RecordingCompany_ID;
    @Column(nullable = false)
    private String TradingName;
    private String CompanyRegistrationNumber;
    private LocalDate DateOfRegistration;
    private int TaxNumber;
    private int VatNumber;
    private String website;

    //using the existing address block
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Address_Id")
    private Address Address;

    private String Telephone;
    @Column(nullable = false)
    private String Cellphone;
    @Column(nullable = false)
    private String Email;
    //recodring members details
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recordingmembers_Id")
    private recordingmembers recordingmembers;
    //bank details
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BankDetails_Id",nullable = false)
    private BankDetails BankDetails;


}
