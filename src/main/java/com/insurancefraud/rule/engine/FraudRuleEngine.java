package com.insurancefraud.rule.engine;

import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.rule.evaluator.FraudRuleEvaluator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudRuleEngine {

    private final List<FraudRuleEvaluator> rules;

    public List<String> evaluate(FraudEvent event) {

        return rules.stream()
                .filter(rule -> rule.evaluate(event))
                .map(FraudRuleEvaluator::getRuleName)
                .toList();
    }
}