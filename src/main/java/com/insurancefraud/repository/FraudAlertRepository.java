package com.insurancefraud.repository;

import com.insurancefraud.domain.entity.FraudAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudAlertRepository
    extends JpaRepository<FraudAlert, UUID> {

}

