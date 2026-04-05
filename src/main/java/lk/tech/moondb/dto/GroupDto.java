package lk.tech.moondb.dto;

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
public class GroupDto {
    private Long id;

    @NotBlank(message = "URL is mandatory")
    private String url;

    @NotBlank(message = "Tile is mandatory")
    private String tile;
    private List<AreaDto> areas;
}
