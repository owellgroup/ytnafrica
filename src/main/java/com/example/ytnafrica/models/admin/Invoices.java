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
    //Company details where the invoice is coming from
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="OriginCampanydetails_id")
    private OriginCompanyDetails origincompanydetails;
    //banking details for the company where the invoice is coming from
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="OriginCompanybankdetails_id")
    private OrginCompanybankDetaills OriginCompanybankdetails;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CompanyDetails_id")
    private CompanyDetails BillTo;
    //
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="InvoiceServiceType_id")
    private InvoiceServiceType InvoiceServiceType;
    private int TotalUsed;
    private double UnitPrice;
    private double TotalPayable;
    private double Total;
    private double TotalTax;

    //declatation notes for the invoices
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="InvoiceDeclarationNotes")
    private InvoiceDeclarationNotes InvoiceDeclarationNotes;



}
