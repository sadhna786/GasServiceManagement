package gasUtility.example.GasUtility.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import gasUtility.example.GasUtility.entity.ServiceRequest;

import java.util.List;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    List<ServiceRequest> findByCustomerId(String customerId);
}
