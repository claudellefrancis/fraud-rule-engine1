package com.insurancefraud.repository;

import com.insurancefraud.domain.entity.FraudCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FraudCaseRepository
        extends JpaRepository<FraudCase, UUID> {
}