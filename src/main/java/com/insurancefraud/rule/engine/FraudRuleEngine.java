package com.insurancefraud.rule.engine;

import com.insurancefraud.rule.evaluator.FraudRuleEvaluator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudRuleEngine {

    private final List<FraudRuleEvaluator> rules;

    public FraudRuleEngine(List<FraudRuleEvaluator> rules) {
        this.rules = rules;
    }
}