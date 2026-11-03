package com.insurancefraud.rule.implementation;

import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.rule.evaluator.FraudRuleEvaluator;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaryFraudRule
        implements FraudRuleEvaluator {

    @Override
    public boolean evaluate(FraudEvent event) {
        return false;
    }

    @Override
    public String getRuleName() {
        return "Beneficiary Fraud";
    }
}