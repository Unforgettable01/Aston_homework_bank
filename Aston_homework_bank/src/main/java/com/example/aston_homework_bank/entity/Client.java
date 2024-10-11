package com.example.aston_homework_bank.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = Client.TABLE_NAME)
public class Client {
    public static final String TABLE_NAME = "client";

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "client_name", nullable = false)
    private String clientName;
}
