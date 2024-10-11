package com.example.aston_homework_bank.repository;

import com.example.aston_homework_bank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
