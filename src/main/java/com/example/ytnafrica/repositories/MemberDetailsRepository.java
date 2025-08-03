package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.members.MemberDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDetailsRepository extends JpaRepository<MemberDetails, Long> {
}