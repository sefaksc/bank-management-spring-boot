package com.sefa.BankManagement.mapper;

import com.sefa.BankManagement.entity.User;
import com.sefa.BankManagement.model.authentication.RegisterRequestModel;

public interface UserMapper {
    User toUser(RegisterRequestModel request);
}