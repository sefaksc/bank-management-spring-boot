package com.sefa.BankManagement.service;

import com.sefa.BankManagement.model.authentication.AuthenticationResponseModel;
import com.sefa.BankManagement.model.authentication.LoginRequestModel;
import com.sefa.BankManagement.model.authentication.RegisterRequestModel;

public interface AuthenticationService {
    public AuthenticationResponseModel register(RegisterRequestModel request);

    public AuthenticationResponseModel login(LoginRequestModel request);
}