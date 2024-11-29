package gasUtility.example.GasUtility.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ServiceRequestStatusDto {
    private String type;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;
}
