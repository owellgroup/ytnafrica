package com.example.ytnafrica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BankDetails")
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BankName_Id")
    private BankName BankName;
    @Column(nullable=false)
    private String AccountHolderName;
    @Column(nullable=false)
    private String BankAccountNumber;

    private String BankAccountType;

    private String BankBranchName;

    private String BankBranchNumber;

}
