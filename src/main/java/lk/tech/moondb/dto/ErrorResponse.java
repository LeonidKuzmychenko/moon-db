package lk.tech.moondb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Structured error response")
public class ErrorResponse {
    @Schema(description = "HTTP status code", example = "400")
    private int status;

    @Schema(description = "Error message", example = "Validation failed")
    private String message;

    @Schema(description = "Timestamp of the error")
    private LocalDateTime timestamp;

    @Schema(description = "Detailed field validation errors", example = "{\"authId\": \"Auth ID is mandatory\"}")
    private Map<String, String> errors;
}
