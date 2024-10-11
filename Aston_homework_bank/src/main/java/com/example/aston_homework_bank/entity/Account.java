package com.example.aston_homework_bank.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = Account.TABLE_NAME)
public class Account {
    public static final String TABLE_NAME = "account";

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", foreignKey = @ForeignKey(name = "fk_account_client_id"))
    private Client client;

    @Column(name = "account_password", nullable = false)
    private String accountPassword;

    @Column(name = "balance_on_account")
    private Double balanceOnAccount;

    @Column(name = "account_number")
    private String accountNumber;
}
