package com.ecoreno.model.client;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String email;
    private String phoneNumber;
    private String housingAddress;

    protected Client() {}

    public Client(String name, String email, String phoneNumber, String housingAddress) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.housingAddress = housingAddress;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHousingAddress() {
        return housingAddress;
    }

    public void setHousingAddress(String housingAddress) {
        this.housingAddress = housingAddress;
    }
}
