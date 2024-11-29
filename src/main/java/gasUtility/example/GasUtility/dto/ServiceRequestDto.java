package gasUtility.example.GasUtility.dto;

import lombok.Data;

@Data
public class ServiceRequestDto {
    private String customerId;
    private String type;
    private String details;
}
