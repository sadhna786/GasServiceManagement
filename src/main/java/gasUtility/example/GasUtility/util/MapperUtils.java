package gasUtility.example.GasUtility.util;

import java.time.LocalDateTime;

import gasUtility.example.GasUtility.dto.ServiceRequestDto;
import gasUtility.example.GasUtility.dto.ServiceRequestStatusDto;
import gasUtility.example.GasUtility.entity.ServiceRequest;

public class MapperUtils {

    public static ServiceRequest mapToEntity(ServiceRequestDto dto) {
        ServiceRequest entity = new ServiceRequest();
        entity.setCustomerId(dto.getCustomerId());
        entity.setType(dto.getType());
        entity.setDetails(dto.getDetails());
        entity.setCreatedAt(LocalDateTime.now());
        return entity;
    }

    public static ServiceRequestStatusDto mapToStatusDto(ServiceRequest entity) {
        ServiceRequestStatusDto dto = new ServiceRequestStatusDto();
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setResolvedAt(entity.getResolvedAt());
        return dto;
    }
}
