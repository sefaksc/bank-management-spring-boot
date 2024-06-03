package com.sefa.BankManagement.mapper.impl;

import com.sefa.BankManagement.entity.User;
import com.sefa.BankManagement.mapper.UserProfileMapper;
import com.sefa.BankManagement.model.authentication.UserProfileResponseModel;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapperImpl implements UserProfileMapper {
    @Override
    public UserProfileResponseModel toUserProfile(User user) {
        return UserProfileResponseModel
                .builder()
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}