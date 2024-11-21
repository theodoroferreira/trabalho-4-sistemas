package com.acme.trabalho4sistemas.framework;

import com.acme.trabalho4sistemas.application.CustomerService;
import com.acme.trabalho4sistemas.domain.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/java")
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/post")
    public ResponseEntity<String> saveCustomer(@RequestBody @Validated CustomerDto request) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCustomer(request));
    }
}
