package com.insurancefraud.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "funds_hold") // Specifies table name for this entity
@Getter // Auto-generates getter methods for all fields
@Setter // Auto-generates setter methods for all fields
@NoArgsConstructor // Generates a constructor with no arguments
@AllArgsConstructor // Generates a constructor with  for all fields
@Builder // Enables the builder pattern for creating FraudCase objects

public class FundsHold {
    @Id
    private UUID holdId;

    private String customerId;

    private BigDecimal amount;

    private String holdReason;

    private Integer holdPeriodHours;

    private LocalDateTime createdDate;
}