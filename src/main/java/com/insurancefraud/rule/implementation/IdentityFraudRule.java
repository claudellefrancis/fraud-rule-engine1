package com.insurancefraud.rule.implementation;

import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.rule.evaluator.FraudRuleEvaluator;
import org.springframework.stereotype.Component;

@Component
public class IdentityFraudRule implements FraudRuleEvaluator {

    @Override
    public boolean evaluate(FraudEvent event) {

        return false;

    }
}