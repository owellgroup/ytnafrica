package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}