// Represents investigation cases

package com.insurancefraud.domain.entity;

import com.insurancefraud.domain.enums.CaseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "fraud_case") // Specifies table name for this entity
@Getter // Auto-generates getter methods for all fields
@Setter // Auto-generates setter methods for all fields
@NoArgsConstructor // Generates a constructor with no arguments
@AllArgsConstructor // Generates a constructor with  for all fields
@Builder // Enables the builder pattern for creating FraudCase objects

public class FraudCase {

    @Id
    private UUID caseId;

    // FraudEvent -> FraudAlert -> FraudCase and mirrors SDD
    @OneToOne
    @JoinColumn(name = "alert_id")
    private FraudAlert fraudAlert;

    private String investigator;

    @Enumerated(EnumType.STRING)
        private CaseStatus status;

    private LocalDateTime createdDate;

}