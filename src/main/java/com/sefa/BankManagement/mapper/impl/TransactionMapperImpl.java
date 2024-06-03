package com.sefa.BankManagement.mapper.impl;

import com.sefa.BankManagement.entity.Account;
import com.sefa.BankManagement.entity.Transaction;
import com.sefa.BankManagement.entity.TransactionType;
import com.sefa.BankManagement.mapper.TransactionMapper;
import com.sefa.BankManagement.model.transaction.TransactionResponseModel;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toEntity(double amount, Account account, TransactionType type) {
        return Transaction
                .builder()
                .amount(amount)
                .account(account)
                .type(type)
                .timestamp(new Date())
                .notes("Account Balance" + account.getBalance())
                .build();
    }

    @Override
    public TransactionResponseModel toResponseModel(Long id, double amount, double balance) {
        return TransactionResponseModel
                .builder()
                .id(id)
                .amount(amount)
                .balance(balance)
                .build();
    }
}