package com.example.ytnafrica.models.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="OriginCompanyDetails")
public class OriginCompanyDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    //where the invoice is coming from
    private String CompanyName;
    private String CompanyAddress;
    private String CompanyPhone;
    private String CompanyEmail;
    private String CompanyWebsite;
}
