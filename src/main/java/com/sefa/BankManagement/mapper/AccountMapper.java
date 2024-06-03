package com.sefa.BankManagement.mapper;

import com.sefa.BankManagement.entity.Account;
import com.sefa.BankManagement.model.account.AccountResponseModel;

public interface AccountMapper {
    AccountResponseModel toResponseModel(Account account);
}