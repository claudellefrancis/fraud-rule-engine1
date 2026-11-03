package com.insurancefraud.controller;

import com.insurancefraud.domain.entity.FraudAlert;
import com.insurancefraud.repository.FraudAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final FraudAlertRepository fraudAlertRepository;

    @GetMapping
    public List<FraudAlert> getAllAlerts() {
        return fraudAlertRepository.findAll();
    }
}