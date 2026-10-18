package com.insurancefraud.repository;

import com.insurancefraud.domain.entity.FraudEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudEventRepository
        extends JpaRepository<FraudEvent, UUID> {
}