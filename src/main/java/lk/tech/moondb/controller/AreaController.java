package lk.tech.moondb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lk.tech.moondb.dto.AreaCreateRequest;
import lk.tech.moondb.dto.AreaDto;
import lk.tech.moondb.dto.ErrorResponse;
import lk.tech.moondb.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
@Tag(name = "Area Controller", description = "Operations related to areas")
public class AreaController {

    private final AreaService areaService;

    @PostMapping("/group/{groupId}")
    @Operation(summary = "Create a new area for a group")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Area created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data or Area already exists",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Group not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public AreaDto create(@PathVariable Long groupId, @Valid @RequestBody AreaCreateRequest request) {
        return areaService.create(groupId, request);
    }

    @GetMapping("/group/{groupId}")
    @Operation(summary = "Get all areas for a specific group")
    public List<AreaDto> getByGroup(@PathVariable Long groupId) {
        return areaService.getByGroup(groupId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete area by ID")
    public void delete(@PathVariable Long id) {
        areaService.delete(id);
    }
}