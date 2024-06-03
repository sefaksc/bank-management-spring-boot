package com.sefa.BankManagement.service;

import com.sefa.BankManagement.model.account.AccountResponseModel;

import java.util.List;

public interface AccountService {
    AccountResponseModel createNewAccount();

    List<AccountResponseModel> getMyAccounts();
}
