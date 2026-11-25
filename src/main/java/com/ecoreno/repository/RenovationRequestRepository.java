package com.ecoreno.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecoreno.model.renovationrequest.RenovationRequest;
import com.ecoreno.model.renovationrequest.RenovationType;
import com.ecoreno.model.renovationrequest.Status;

public interface RenovationRequestRepository extends JpaRepository<RenovationRequest, UUID>{
    List<RenovationRequest> findByStatus(Status status);
    List<RenovationRequest> findByRenovationType(RenovationType renovationType);
    List<RenovationRequest> findByStatusAndRenovationType(Status status, RenovationType renovationType);
}
