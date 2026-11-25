package com.ecoreno.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecoreno.model.client.Client;

public interface ClientRepository extends JpaRepository<Client, UUID>{ }
