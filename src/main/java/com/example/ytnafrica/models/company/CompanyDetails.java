package com.example.ytnafrica.models.company;

import com.example.ytnafrica.models.Address;
import com.example.ytnafrica.models.BankDetails;
import com.example.ytnafrica.models.License_Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CompanyDetails")
public class CompanyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String CompanyName;
    private String registration_Number;
    private String CompanyEmail;
    private String CompanyPhone;
    private String Industry;
    private String legal_structure;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Address_Id")
    private Address address;
    //bank details
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BankDetails_Id")
    private BankDetails BankDetails;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="License_Type_id")
    private License_Type License_Type;
}
