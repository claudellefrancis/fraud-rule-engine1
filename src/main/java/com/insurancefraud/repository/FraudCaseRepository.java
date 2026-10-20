package com.insurancefraud.repository;

import com.insurancefraud.domain.entity.FraudCase;

public interface FraudCaseRepository
        extends JpaRepository<FraudCase, UUID> {
}