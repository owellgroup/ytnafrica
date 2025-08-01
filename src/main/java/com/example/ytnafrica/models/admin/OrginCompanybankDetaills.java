package com.example.ytnafrica.models.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="OriginBankDetails")
public class OrginCompanybankDetaills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String PaymentMethod;
    private String BankName;
    private String BankAccountName;
    private String BankAccountNumber;
    private String BranchName;
    private String BranchCode;
}
