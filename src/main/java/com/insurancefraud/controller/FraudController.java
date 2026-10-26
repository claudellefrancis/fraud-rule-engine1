package com.insurancefraud.controller;

import com.insurancefraud.domain.entity.FraudEvent;
import com.insurancefraud.service.FraudDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final FraudDetectionService fraudDetectionService;

    @PostMapping("/evaluate")
    public List<String> evaluate(@RequestBody FraudEvent event) {

        return fraudDetectionService.evaluate(event);
    }
}