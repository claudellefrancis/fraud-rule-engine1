package com.insurancefraud.repository;

import com.insurancefraud.domain.entity.FraudEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface FraudEventRepository
        extends JpaRepository<FraudEvent, UUID> {

    // Count how many records have the phone number AND eventDate > Today - 30 days
    long countByPhoneNumberAndEventDateAfter(
            String phoneNumber,
            LocalDateTime date);
}