package lk.tech.moondb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request to create a new group")
public class GroupCreateRequest {

    @NotBlank(message = "URL is mandatory")
    @Schema(description = "Link to the group content", example = "https://example.com/group")
    private String url;

    @NotBlank(message = "Tile is mandatory")
    @Schema(description = "Display title or identifier for the group tile", example = "Group A")
    private String tile;
}
