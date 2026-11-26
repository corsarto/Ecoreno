package com.ecoreno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ecoreno.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/clients")
    public String ListOfAllClients(Model model) {
        model.addAttribute("clients", service.findAllClients());
        return "clients";
    }
    
}
