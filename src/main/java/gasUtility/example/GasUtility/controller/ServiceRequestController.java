package gasUtility.example.GasUtility.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gasUtility.example.GasUtility.dto.ServiceRequestDto;
import gasUtility.example.GasUtility.dto.ServiceRequestStatusDto;
import gasUtility.example.GasUtility.service.ServiceRequestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class ServiceRequestController {

    private final ServiceRequestService service;

    @PostMapping
    public ResponseEntity<String> createRequest(@RequestBody ServiceRequestDto requestDto) {
        Long requestId = service.createServiceRequest(requestDto);
        return ResponseEntity.ok("Request created with ID: " + requestId);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<ServiceRequestStatusDto>> getRequests(@PathVariable String customerId) {
        return ResponseEntity.ok(service.getServiceRequests(customerId));
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequestStatusDto>> getAllRequests() {
        List<ServiceRequestStatusDto> requests = service.getAllServiceRequests();
        return ResponseEntity.ok(requests);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestParam String status) {
        service.updateServiceRequestStatus(id, status);
        return ResponseEntity.ok("Service request status updated to: " + status);
    }
    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteServiceRequest(@PathVariable Long id) {
    boolean isDeleted = service.deleteServiceRequest(id);
    if (isDeleted) {
        return ResponseEntity.ok("Service request deleted successfully");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service request not found");
    }
}


}


