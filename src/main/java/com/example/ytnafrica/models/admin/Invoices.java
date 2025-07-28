package com.example.ytnafrica.models.admin;

import com.example.ytnafrica.models.company.CompanyDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="invoices")
public class Invoices {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    private String InvoiceNumber;
    private LocalDate Invoicedate;
    private LocalTime InvoiceDueDate;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="InvoiceStatus_Id")
    private InvoiceStatus InvoiceStatus;
    //Company details where the invoice is coming from
    private String CompanyName;
    private String CompanyAddress;
    private String CompanyPhone;
    private String CompanyEmail;
    private String CompanyWebsite;
    //banking details for the company where the invoice is coming from
    private String PaymentMethod;
    private String BankName;
    private String BankAccountName;
    private String BankAccountNumber;
    private String BranchName;
    private String BranchCode;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CompanyDetails_Id")
    private CompanyDetails BillTo;
    //
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="InvoiceServiceType_Id")
    private InvoiceServiceType InvoiceServiceType;
    private int TotalUsed;
    private double UnitPrice;
    private double Total;
    private double TotalTax;
    private double TotalPayable;


}
