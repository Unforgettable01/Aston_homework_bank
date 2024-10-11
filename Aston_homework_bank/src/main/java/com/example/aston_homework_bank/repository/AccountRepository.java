package com.example.aston_homework_bank.repository;

import com.example.aston_homework_bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
