package lk.tech.moondb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lk.tech.moondb.dto.ErrorResponse;
import lk.tech.moondb.dto.GroupDto;
import lk.tech.moondb.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
@Tag(name = "Group Controller", description = "Operations related to groups")
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/user/{userId}")
    @Operation(summary = "Create a new group for a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Group created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "User not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public GroupDto create(@PathVariable Long userId, @Valid @RequestBody GroupDto groupDto) {
        return groupService.create(userId, groupDto);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get all groups for a specific user")
    public List<GroupDto> getByUser(@PathVariable Long userId) {
        return groupService.getByUser(userId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get group by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Group found"),
            @ApiResponse(responseCode = "500", description = "Group not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public GroupDto get(@PathVariable Long id) {
        return groupService.get(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete group by ID")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }
}