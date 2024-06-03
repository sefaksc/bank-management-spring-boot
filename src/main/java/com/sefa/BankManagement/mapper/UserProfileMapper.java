package com.sefa.BankManagement.mapper;

import com.sefa.BankManagement.entity.User;
import com.sefa.BankManagement.model.authentication.UserProfileResponseModel;

public interface UserProfileMapper {
    UserProfileResponseModel toUserProfile(User user);
}