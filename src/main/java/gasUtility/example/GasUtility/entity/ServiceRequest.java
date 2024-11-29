package gasUtility.example.GasUtility.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;
    private String type; // e.g., "Gas Leak", "Billing Issue"
    private String details;
    private String status; // e.g., "Pending", "In Progress", "Resolved"
    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;
}

