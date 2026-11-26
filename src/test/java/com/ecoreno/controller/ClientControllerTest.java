package com.ecoreno.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ecoreno.model.client.Client;
import com.ecoreno.service.ClientService;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired 
    private MockMvc mockMvc;

    @MockitoBean
    private ClientService service;

    @Test
    @WithMockUser 
    void listsAllClient() throws Exception{
        Client clientOne = new Client("Lucas Petit", "lucas.petit@example.com", "0656789012", "14 rue des Mimosas, 66000 Perpignan");
        Client clientTwo = new Client("Emma Laurent", "emma.laurent@example.com", "0678901234", "32 avenue Jean Jaurès, 34000 Montpellier");
        when(service.findAllClients()).thenReturn(List.of(clientOne, clientTwo));

        mockMvc.perform(MockMvcRequestBuilders.get("/clients"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.view().name("clients"))
               .andExpect(MockMvcResultMatchers.model().attribute("clients", List.of(clientOne, clientTwo)));         
    }
}
