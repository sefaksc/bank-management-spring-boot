package com.sefa.BankManagement.mapper;

import com.sefa.BankManagement.entity.Account;
import com.sefa.BankManagement.entity.Transaction;
import com.sefa.BankManagement.entity.TransactionType;
import com.sefa.BankManagement.model.transaction.TransactionResponseModel;

public interface TransactionMapper {
    Transaction toEntity(double amount, Account account, TransactionType type);
    TransactionResponseModel toResponseModel(Long id, double amount, double balance);
}