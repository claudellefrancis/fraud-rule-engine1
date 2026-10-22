package com.insurancefraud.rule.implementation;

import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.repository.FraudEventRepository;
import com.insurancefraud.rule.evaluator.FraudRuleEvaluator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class IdentityFraudRule
        implements FraudRuleEvaluator {

     private final FraudEventRepository fraudEventRepository;

    @Override
    // New event arrives
    public boolean evaluate(FraudEvent event) {

        LocalDateTime thirtyDaysAgo =
                LocalDateTime.now().minusDays(30);

        long count =
                 fraudEventRepository
                        .countByPhoneNumberAndEventDateAfter(
                                event.getPhoneNumber(),
                                thirtyDaysAgo);

                                return  count > 3;
    }

    @Override
    public String getRuleName() {

        return "Identity Fraud Rule";
    }
}