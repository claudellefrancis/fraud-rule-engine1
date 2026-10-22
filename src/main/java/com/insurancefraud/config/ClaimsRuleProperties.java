package com.insurancefraud.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ConfigurationProperties(prefix = "fraud.claims")
@Getter
@Setter
public class ClaimsRuleProperties {

    private BigDecimal threshold;
}