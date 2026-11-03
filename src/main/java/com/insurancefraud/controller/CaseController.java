package com.insurancefraud.controller;

import com.insurancefraud.domain.entity.FraudCase;
import com.insurancefraud.repository.FraudCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor
public class CaseController {

    private final FraudCaseRepository fraudCaseRepository;

    @GetMapping
    public List<FraudCase> getAllCases() {
        return fraudCaseRepository.findAll();
    }
}