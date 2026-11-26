package com.ecoreno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoreno.model.client.Client;
import com.ecoreno.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> findAllClients() {
        return repository.findAll();
    }
}
