package com.sefa.BankManagement.service.impl;

import com.sefa.BankManagement.entity.Account;
import com.sefa.BankManagement.entity.User;
import com.sefa.BankManagement.mapper.AccountMapper;
import com.sefa.BankManagement.model.account.AccountResponseModel;
import com.sefa.BankManagement.repository.AccountRepository;
import com.sefa.BankManagement.repository.UserRepository;
import com.sefa.BankManagement.service.AccountService;
import com.sefa.BankManagement.utils.Utils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponseModel createNewAccount() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User " + email + " Not Found"));

        Account account = accountRepository.save(
                Account
                        .builder()
                        .cardNumber(generateUniqueCardNumber())
                        .cvv(Utils.generateCVV())
                        .balance(0.0)
                        .user(user)
                        .build()
        );

        return accountMapper.toResponseModel(account);
    }

    @Override
    public List<AccountResponseModel> getMyAccounts() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User " + email + " Not Found"));

        return accountRepository
                .findAllByUser(user)
                .stream()
                .map(accountMapper::toResponseModel)
                .toList();
    }

    public String generateUniqueCardNumber() {
        String cardNumber = Utils.generateCardNumber();

        while (accountRepository.existsByCardNumber(cardNumber)) {
            cardNumber = Utils.generateCardNumber();
        }

        return cardNumber;
    }
}
