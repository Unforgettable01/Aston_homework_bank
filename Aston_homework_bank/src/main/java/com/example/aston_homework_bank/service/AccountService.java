package com.example.aston_homework_bank.service;

import com.example.aston_homework_bank.entity.Account;
import com.example.aston_homework_bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public Account balanceOnAccount(Long accountId, double amount) {
        Account account = getAccount(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalanceOnAccount(account.getBalanceOnAccount() + amount);
        return accountRepository.save(account);
    }

    public Account cashWithdrawalL(Long accountId, double amount) {
        Account account = getAccount(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalanceOnAccount() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        account.setBalanceOnAccount(account.getBalanceOnAccount() - amount);
        return accountRepository.save(account);
    }

    public Account transfer(Long accountId, double amount, Long toAccountId) {
        Account account = getAccount(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        Account accountTo = getAccount(accountId).orElseThrow(() -> new RuntimeException("AccountTo not found"));

        if (account.getBalanceOnAccount() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        accountTo.setBalanceOnAccount(accountTo.getBalanceOnAccount() + amount);
        account.setBalanceOnAccount(account.getBalanceOnAccount() - amount);
        accountRepository.save(account);
        accountRepository.save(accountTo);
        return account;
    }
}
