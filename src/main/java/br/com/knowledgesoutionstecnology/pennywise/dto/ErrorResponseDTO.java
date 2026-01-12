package br.com.knowledgesoutionstecnology.pennywise.dto;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ErrorResponseDTO {
    private String message;
    private Map<String, String> errors;
    private LocalDateTime timestamp;
    private int status;
}
