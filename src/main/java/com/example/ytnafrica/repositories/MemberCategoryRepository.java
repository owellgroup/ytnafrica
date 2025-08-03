package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.MemberCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCategoryRepository extends JpaRepository<MemberCategory, Long> {
}