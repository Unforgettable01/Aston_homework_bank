package com.example.aston_homework_bank.controller;

import com.example.aston_homework_bank.entity.TransactionHistory;
import com.example.aston_homework_bank.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/transactionHistory")
public class TransactionHistoryController {
    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @GetMapping("/{transactionHistoryId}")
    public TransactionHistory getTransactionHistory(@PathVariable Long transactionHistoryId) {
        return transactionHistoryService.getTransactionHistory(transactionHistoryId).orElseThrow(() -> new RuntimeException("Transaction history not found"));
    }

    @PostMapping
    public TransactionHistory createTransactionHistory(@RequestBody TransactionHistory transactionHistory) {
        return transactionHistoryService.createTransactionHistory(transactionHistory);
    }
}
