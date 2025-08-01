package com.example.ytnafrica.models.admin;

import com.example.ytnafrica.models.members.MemberDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Payments")
public class Payments {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MembersDetails_Id")
    private MemberDetails memberDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Perfomance_Id")
    private Perfomance perfomance;
    private double Totalamount;
    private LocalDate date;

}
