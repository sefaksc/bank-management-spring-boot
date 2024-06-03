package com.sefa.BankManagement.service.impl;

import com.sefa.BankManagement.entity.Account;
import com.sefa.BankManagement.entity.Transaction;
import com.sefa.BankManagement.entity.TransactionType;
import com.sefa.BankManagement.exception.LowBalanceException;
import com.sefa.BankManagement.mapper.TransactionMapper;
import com.sefa.BankManagement.model.transaction.DepositRequestModel;
import com.sefa.BankManagement.model.transaction.TransactionResponseModel;
import com.sefa.BankManagement.model.transaction.WithdrawRequestModel;
import com.sefa.BankManagement.repository.AccountRepository;
import com.sefa.BankManagement.repository.TransactionRepository;
import com.sefa.BankManagement.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionResponseModel deposit(DepositRequestModel request) {
        Account account = accountRepository
                .findByCardNumber(request.getCard_number())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        Long transactionId = performDeposit(account, request.getAmount());

        return transactionMapper.toResponseModel(transactionId, request.getAmount(), account.getBalance());
    }

    @Override
    public TransactionResponseModel withdraw(WithdrawRequestModel request) {
        Account account = accountRepository
                .findByCardNumberAndCvv(request.getCard_number(), request.getCvv())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        Long transactionId = performWithdrawal(account, request.getAmount());

        return transactionMapper.toResponseModel(transactionId, request.getAmount(), account.getBalance());
    }

    private Long performDeposit(Account account, double amount) {
        updateAccountBalance(account, amount);
        Transaction transaction = transactionRepository.save(transactionMapper.toEntity(amount, account, TransactionType.DEPOSIT));
        return transaction.getId();
    }

    private Long performWithdrawal(Account account, double amount) {
        if (account.getBalance() < amount) {
            throw new LowBalanceException("Your Balance " + account.getBalance() + " is not enough to withdraw " + amount);
        }

        updateAccountBalance(account, -amount);
        Transaction transaction = transactionRepository.save(transactionMapper.toEntity(amount, account, TransactionType.WITHDRAW));
        return transaction.getId();
    }

    private void updateAccountBalance(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }
}
