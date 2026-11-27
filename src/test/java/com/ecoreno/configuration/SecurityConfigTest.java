package com.ecoreno.configuration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecurityConfigTest {
 
    private SecurityConfig securityConfig;

    @BeforeEach
    void setUp() {
       securityConfig = new SecurityConfig(); 
    }

    @Test
    void matchesReturnsTrueForValidPassword() {
        String rawPassword = "myPassword";
        String hashPassword = "$2a$10$PwbLPS/0C1x2L1KLn7hMf.PN37/IqcL9lCZpCkzgh/CQa9o/a7WgC";

        assertTrue(securityConfig.passwordEncoder().matches(rawPassword, hashPassword));
    }

    @Test
    void matchesReturnsFalseForInvalidPassword() {
        String hashPassword = "$2a$10$PwbLPS/0C1x2L1KLn7hMf.PN37/IqcL9lCZpCkzgh/CQa9o/a7WgC";

        assertFalse(securityConfig.passwordEncoder().matches("mauvaisMotDePasse", hashPassword));
    }
}
