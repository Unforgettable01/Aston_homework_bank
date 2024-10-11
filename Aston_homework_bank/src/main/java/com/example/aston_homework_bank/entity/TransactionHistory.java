package com.example.aston_homework_bank.entity;

import com.example.aston_homework_bank.entity.constant.TransactionType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = TransactionHistory.TABLE_NAME)
public class TransactionHistory {
    public static final String TABLE_NAME = "transaction_history";

    @Id
    @Column(name = "transaction_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionHistoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Column(name = "amount")
    private Double amount;
}
