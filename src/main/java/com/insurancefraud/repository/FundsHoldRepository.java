package com.insurancefraud.repository;

import com.insurancefraud.domain.entity.FundsHold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FundsHoldRepository
        extends JpaRepository<FundsHold, UUID> {
}