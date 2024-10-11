package com.example.aston_homework_bank.service;

import com.example.aston_homework_bank.entity.Client;
import com.example.aston_homework_bank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getClient(Long clientId) {
        return clientRepository.findById(clientId);
    }

}
