package com.insurancefraud.rule.evaluator;

import com.insurancefraud.domain.entity.FraudEvent;

public interface FraudRuleEvaluator {

    boolean evaluate(FraudEvent event);

    String getRuleName();

}