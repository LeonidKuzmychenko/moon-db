package lk.tech.moondb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request to create a new user")
public class UserCreateRequest {

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    @Schema(description = "User email address", example = "user@example.com")
    private String email;
}
