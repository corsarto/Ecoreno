package com.ecoreno.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ecoreno.model.employee.Employee;
import com.ecoreno.model.employee.Role;
import com.ecoreno.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock 
    private EmployeeRepository repository;

    private CustomUserDetailsService service;

    @BeforeEach 
    void setUp() {
        service = new CustomUserDetailsService(repository);
    }

    @Test 
    void loadUserByEmail() {
        Employee employee = new Employee("Alex", "alex@ecoreno.test", "$2a$10$PwbLPS/0C1x2L1KLn7hMf.PN37/IqcL9lCZpCkzgh/CQa9o/a7WgC", Role.EMPLOYE);
        when(repository.findByEmail("alex@ecoreno.test")).thenReturn(Optional.of(employee));

        UserDetails result = service.loadUserByUsername("alex@ecoreno.test");

        assertThat(result.getUsername()).isEqualTo(employee.getEmail());
        assertThat(result.getPassword()).isEqualTo(employee.getPassword());
        assertThat(result.getAuthorities()).extracting(GrantedAuthority::getAuthority).containsExactly("ROLE_EMPLOYE");
    }

    @Test 
    void rejectLoadUserByEmail() {
        when(repository.findByEmail("inconnu@ecoreno.test")).thenReturn(Optional.empty());
        
        assertThatThrownBy(() -> service.loadUserByUsername("inconnu@ecoreno.test")).isInstanceOf(UsernameNotFoundException.class);
    }
}
