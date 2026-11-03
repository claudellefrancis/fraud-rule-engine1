package com.insurancefraud.rule.implementation;

import com.insurancefraud.config.ClaimsRuleProperties;
import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.rule.evaluator.FraudRuleEvaluator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Component
public class ClaimsFraudRule implements FraudRuleEvaluator {

    private final ClaimsRuleProperties claimsRuleProperties;

    @Override
    public boolean evaluate(FraudEvent event) {

        if (event.getPolicyStartDate() == null ||
                event.getClaimDate() == null ||
                event.getClaimAmount() == null) {

            return false;
        }

        long daysBetween =
                ChronoUnit.DAYS.between(
                        event.getPolicyStartDate(),
                        event.getClaimDate());

        return daysBetween < 90
                && event.getClaimAmount()
                .compareTo(claimsRuleProperties.getThreshold()) > 0;
    }

    @Override
    public String getRuleName() {
        return "Claims Fraud";
    }
}