package com.proxym.fraudDetection.repositories;

import com.proxym.fraudDetection.entities.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {
}
