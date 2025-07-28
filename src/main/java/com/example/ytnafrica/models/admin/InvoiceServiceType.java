package com.example.ytnafrica.models.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="InvoiceItems")
public class InvoiceServiceType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String invoiceServiceName; // Audio Broadcasting/ Video Broadcasting
}
