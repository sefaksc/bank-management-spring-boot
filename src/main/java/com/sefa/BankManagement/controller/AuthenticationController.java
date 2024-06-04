package com.sefa.BankManagement.controller;

import com.sefa.BankManagement.model.ResponseModel;
import com.sefa.BankManagement.model.authentication.LoginRequestModel;
import com.sefa.BankManagement.model.authentication.RegisterRequestModel;
import com.sefa.BankManagement.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ResponseModel> register(@Valid @RequestBody RegisterRequestModel request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseModel
                        .builder()
                        .status(HttpStatus.CREATED)
                        .success(true)
                        .data(authenticationService.register(request))
                        .build()
                );
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseModel> login(@Valid @RequestBody LoginRequestModel request) {
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .status(HttpStatus.OK)
                        .success(true)
                        .data(authenticationService.login(request))
                        .build()
        );
    }
}