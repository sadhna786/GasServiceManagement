package gasUtility.example.GasUtility.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gasUtility.example.GasUtility.dto.ServiceRequestDto;
import gasUtility.example.GasUtility.dto.ServiceRequestStatusDto;
import gasUtility.example.GasUtility.entity.ServiceRequest;
import gasUtility.example.GasUtility.exception.CustomException;
import gasUtility.example.GasUtility.repository.ServiceRequestRepository;
import gasUtility.example.GasUtility.util.MapperUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceRequestService {


    private final ServiceRequestRepository repository;

    public Long createServiceRequest(ServiceRequestDto requestDto) {
        ServiceRequest request = MapperUtils.mapToEntity(requestDto);
        request.setStatus("Pending");
        return repository.save(request).getId();
    }

    public List<ServiceRequestStatusDto> getServiceRequests(String customerId) {
        return repository.findByCustomerId(customerId).stream()
                .map(MapperUtils::mapToStatusDto)
                .collect(Collectors.toList());
    }

     public void updateServiceRequestStatus(Long id, String status) {
        ServiceRequest request = repository.findById(id)
                .orElseThrow(() -> new CustomException("Service Request not found"));
        request.setStatus(status);
        repository.save(request);

    
    }

    public boolean deleteServiceRequest(Long id) {
        // Assuming you have a repository or DAO to interact with your database
        Optional<ServiceRequest> request = repository.findById(id);
        if (request.isPresent()) {
            repository.delete(request.get());
            return true;
        }
        return false; // If the service request doesn't exist, return false
    }

    public List<ServiceRequestStatusDto> getAllServiceRequests() {
        return repository.findAll().stream()
                .map(MapperUtils::mapToStatusDto)
                .collect(Collectors.toList());
    }
    
}
