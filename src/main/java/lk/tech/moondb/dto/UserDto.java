package lk.tech.moondb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User information")
public class UserDto {
    @Schema(description = "Unique ID in the database", example = "1")
    private Long id;

    @NotBlank(message = "Auth ID is mandatory")
    @Schema(description = "External Auth ID (e.g. from Firebase or Keycloak)", example = "auth0|123456")
    private String authId;

    @Schema(description = "List of groups assigned to the user")
    private List<GroupDto> groups;
}
