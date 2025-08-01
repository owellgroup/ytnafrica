package com.example.ytnafrica.models.admin;

import com.example.ytnafrica.models.members.MemberDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ArtistPayments {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    //getting members details like First name and surname, phone numbers e.t.c and bank details, also Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MembersDetails_Id")
    private MemberDetails memberDets;
    //pay
    private int totalplay;
    private double totalpay;


}

