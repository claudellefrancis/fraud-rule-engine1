package com.insurancefraud.domain.entity;

import com.insurancefraud.domain.enums.CaseStatus;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_case")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudCase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "case_id")
    private UUID caseId;

    @OneToOne
    @JoinColumn(name = "alert_id")
    private FraudAlert fraudAlert;

    private String investigator;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    private LocalDateTime createdDate;
}