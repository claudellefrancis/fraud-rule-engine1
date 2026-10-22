package com.insurancefraud.repository;

import com.insurancefraud.domain.entity.FraudCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudCaseRepository
        extends JpaRepository<FraudCase, UUID> {
}