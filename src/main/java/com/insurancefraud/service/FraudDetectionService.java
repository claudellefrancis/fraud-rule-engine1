package com.insurancefraud.service;

import com.insurancefraud.domain.entity.FraudAlert;
import com.insurancefraud.domain.entity.FraudCase;
import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.domain.enums.AlertStatus;
import com.insurancefraud.domain.enums.CaseStatus;
import com.insurancefraud.domain.enums.RiskLevel;
import com.insurancefraud.repository.FraudEventRepository;
import com.insurancefraud.repository.FraudAlertRepository;
import com.insurancefraud.repository.FraudCaseRepository;
import com.insurancefraud.rule.engine.FraudRuleEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FraudDetectionService {

    private final FraudRuleEngine fraudRuleEngine;

    private final FraudAlertRepository fraudAlertRepository;

    private final FraudEventRepository fraudEventRepository;

    private final FraudCaseRepository fraudCaseRepository;

    public List<String> evaluate(FraudEvent event) {

        List<String> triggeredRules =
                fraudRuleEngine.evaluate(event);

        if(!triggeredRules.isEmpty()) {

            FraudEvent savedEvent = fraudEventRepository.save(event);

            FraudAlert alert =
                    FraudAlert.builder()
                            .fraudEvent(savedEvent)
                            .ruleTriggered(
                                    triggeredRules.get(0))
                            .riskLevel(RiskLevel.HIGH)
                            .status(AlertStatus.OPEN)
                            .alertDate(LocalDateTime.now())
                            .build();

            FraudAlert savedAlert =
                    fraudAlertRepository.save(alert);

            FraudCase fraudCase =
                    FraudCase.builder()
                            .fraudAlert(savedAlert)
                            .investigator("UNASSIGNED")
                            .status(CaseStatus.OPEN)
                            .createdDate(LocalDateTime.now())
                            .build();

            System.out.println("Case ID = " + fraudCase.getCaseId());
            System.out.println("Alert ID = " + savedAlert.getAlertId());
            fraudCaseRepository.save(fraudCase);

        }

        return triggeredRules;
    }

}