package com.insurancefraud.service;

import com.insurancefraud.domain.entity.FraudAlert;
import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.domain.enums.AlertStatus;
import com.insurancefraud.domain.enums.RiskLevel;
import com.insurancefraud.repository.FraudAlertRepository;
import com.insurancefraud.rule.engine.FraudRuleEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FraudDetectionService {

    private final FraudRuleEngine fraudRuleEngine;

    private final FraudAlertRepository fraudAlertRepository;

    public List<String> evaluate(FraudEvent event) {

        List<String> triggeredRules =
                fraudRuleEngine.evaluate(event);

        if(!triggeredRules.isEmpty()) {

            FraudAlert alert =
                    FraudAlert.builder()
                            .alertId(UUID.randomUUID())
                            .ruleTriggered(
                                    triggeredRules.get(0))
                            .riskLevel(RiskLevel.HIGH)
                            .status(AlertStatus.HIGH_RISK)
                            .alertDate(LocalDateTime.now())
                            .build();

            fraudAlertRepository.save(alert);
        }

        return triggeredRules;
    }

}