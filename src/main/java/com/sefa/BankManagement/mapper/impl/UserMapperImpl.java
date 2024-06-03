package com.sefa.BankManagement.mapper.impl;

import com.sefa.BankManagement.entity.Role;
import com.sefa.BankManagement.entity.User;
import com.sefa.BankManagement.mapper.UserMapper;
import com.sefa.BankManagement.model.authentication.RegisterRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User toUser(RegisterRequestModel request) {
        return User
                .builder()
                .name(request.getName())
                .role(Role.USER)
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }
}
