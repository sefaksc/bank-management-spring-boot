package com.sefa.BankManagement.service;

import com.sefa.BankManagement.model.transaction.DepositRequestModel;
import com.sefa.BankManagement.model.transaction.TransactionResponseModel;
import com.sefa.BankManagement.model.transaction.WithdrawRequestModel;

public interface TransactionService {
    TransactionResponseModel deposit(DepositRequestModel request);
    TransactionResponseModel withdraw(WithdrawRequestModel request);
}
