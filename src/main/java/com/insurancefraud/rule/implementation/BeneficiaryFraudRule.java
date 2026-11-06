package com.insurancefraud.rule.implementation;

import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.rule.evaluator.FraudRuleEvaluator;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class BeneficiaryFraudRule implements FraudRuleEvaluator {

    @Override
    public boolean evaluate(FraudEvent event) {

        System.out.println("Beneficiary fraud rule executing");

        if (!Boolean.TRUE.equals(event.getBeneficiaryChanged())) {
            System.out.println("Beneficiary not changed");
            return false;
        }

        if (event.getBeneficiaryChangeDate() == null ||
                event.getPayoutDate() == null) {

            System.out.println("Missing dates");
            return false;
        }

        long daysBetween = ChronoUnit.DAYS.between(
                event.getBeneficiaryChangeDate(),
                event.getPayoutDate()
        );

        System.out.println("Days between: " + daysBetween);

        return daysBetween >= 0 && daysBetween < 30;
    }

    @Override
    public String getRuleName() {
        return "Beneficiary Fraud";
    }
}