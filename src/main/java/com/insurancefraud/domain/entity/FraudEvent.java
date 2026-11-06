// Represents incoming fraud events

package com.insurancefraud.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID eventId;

    private String customerId;

    private String policyNumber;

    private BigDecimal amount;

    private BigDecimal claimAmount;

    private LocalDateTime eventDate;

    private String phoneNumber;

    private String beneficiaryAccount;

    private LocalDate policyStartDate;

    private LocalDate claimDate;

    private Boolean payoutReceived;

    private Boolean beneficiaryChanged;

    private LocalDate beneficiaryChangeDate;

    private LocalDate payoutDate;


}