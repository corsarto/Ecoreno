package com.ecoreno.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import com.ecoreno.model.client.Client;
import com.ecoreno.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock 
    private ClientRepository repository;

    private ClientService service;

    @BeforeEach 
    void setUp() {
        service = new ClientService(repository);
    }

    @Test 
    void returnsClient() {
        Client clientOne = new Client("Lucas Petit", "lucas.petit@example.com", "0656789012", "14 rue des Mimosas, 66000 Perpignan");
        Client clientTwo = new Client("Emma Laurent", "emma.laurent@example.com", "0678901234", "32 avenue Jean Jaurès, 34000 Montpellier");
        when(repository.findAll(Sort.by("name"))).thenReturn(List.of(clientOne, clientTwo));

        List<Client> result = service.findAllClients();

        assertThat(result).containsExactly(clientOne, clientTwo);
    }
}
