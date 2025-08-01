package com.example.ytnafrica.models.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ArtistInvoiceSettlements {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    //getting artist payments details
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ArtistPayments_id")
    private ArtistPayments payments;
    //get the email to send it too
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PayRollsEmails_id")
    private PayRollEmails email;

}
