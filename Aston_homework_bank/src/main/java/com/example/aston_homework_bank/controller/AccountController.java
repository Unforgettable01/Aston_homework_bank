package com.example.aston_homework_bank.controller;

import com.example.aston_homework_bank.entity.Account;
import com.example.aston_homework_bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Long accountId) {
        return accountService.getAccount(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PostMapping("/{accountId}/deposit")
    public Account deposit(@PathVariable Long accuntId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.balanceOnAccount(accuntId, amount);
    }
    @PostMapping("/{accountId}/withdraw")
    public Account withdraw(@PathVariable Long accuntId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.cashWithdrawalL(accuntId, amount);
    }
    @PostMapping("/{accountId}/transfer")
    public Account transfer(@PathVariable Long accuntId, @RequestBody Map<List, Double> request) {
        Double amount = request.get("amount");
        return accountService.cashWithdrawalL(accuntId, amount);
    }
}
