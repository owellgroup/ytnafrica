package com.example.ytnafrica.models.admin;

import com.example.ytnafrica.models.company.CompanyDetails;
import com.example.ytnafrica.models.company.LogSheet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PaymentsCalculator")
public class Perfomance {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LogSheet_id")
    private LogSheet logSheet;// we recieve the logsheet from the company and calcluale how many times each content was selected
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyDetails_id")
    private CompanyDetails companyDetails; //display companies and thier total logsheets

}
