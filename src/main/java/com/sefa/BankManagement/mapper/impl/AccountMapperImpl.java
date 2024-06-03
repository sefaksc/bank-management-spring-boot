package com.sefa.BankManagement.mapper.impl;

import com.sefa.BankManagement.entity.Account;
import com.sefa.BankManagement.mapper.AccountMapper;
import com.sefa.BankManagement.model.account.AccountResponseModel;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {
    @Override
    public AccountResponseModel toResponseModel(Account account) {
        return AccountResponseModel
                .builder()
                .card_number(account.getCardNumber())
                .cvv(account.getCvv())
                .balance(account.getBalance())
                .build();
    }
}