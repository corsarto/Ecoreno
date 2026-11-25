package com.ecoreno.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecoreno.model.employee.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, UUID>{ 
    Optional<Employee> findByEmail(String email);
}
