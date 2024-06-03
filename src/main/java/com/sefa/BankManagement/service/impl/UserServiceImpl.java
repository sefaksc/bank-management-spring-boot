package com.sefa.BankManagement.service.impl;

import com.sefa.BankManagement.entity.User;
import com.sefa.BankManagement.mapper.UserProfileMapper;
import com.sefa.BankManagement.model.authentication.UserProfileResponseModel;
import com.sefa.BankManagement.repository.UserRepository;
import com.sefa.BankManagement.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProfileMapper userProfileMapper;

    @Override
    public UserProfileResponseModel getUserProfile() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User " + email + " Not Found"));

        return userProfileMapper.toUserProfile(user);
    }
}