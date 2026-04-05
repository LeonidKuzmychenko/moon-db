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
@Schema(description = "Information about a user group")
public class GroupDto {
    @Schema(description = "Group ID", example = "10")
    private Long id;

    @NotBlank(message = "URL is mandatory")
    @Schema(description = "Link to the group content", example = "https://example.com/group")
    private String url;

    @NotBlank(message = "Tile is mandatory")
    @Schema(description = "Display title or identifier for the group tile", example = "Group A")
    private String tile;

    @Schema(description = "List of areas within this group")
    private List<AreaDto> areas;
}
