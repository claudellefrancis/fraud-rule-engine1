package com.insurancefraud.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "fraud_event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudEvent {

    @Id
    private UUID eventId;

    private String customerId;

    private String policyNumber;

    private BigDecimal amount;

    private LocalDateTime eventDate;
}