package com.example.aston_homework_bank.service;

import com.example.aston_homework_bank.entity.Account;
import com.example.aston_homework_bank.entity.TransactionHistory;
import com.example.aston_homework_bank.repository.AccountRepository;
import com.example.aston_homework_bank.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionHistoryService {

    @Autowired
    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    public TransactionHistory createTransactionHistory(TransactionHistory transactionHistory) {
        return transactionHistoryRepository.save(transactionHistory);
    }

    public Optional<TransactionHistory> getTransactionHistory(Long transactionHistoryId) {
        return transactionHistoryRepository.findById(transactionHistoryId);
    }
}
