package com.example.aston_homework_bank.controller;

import com.example.aston_homework_bank.entity.Client;
import com.example.aston_homework_bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable Long clientId) {
        return clientService.getClient(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }
}
