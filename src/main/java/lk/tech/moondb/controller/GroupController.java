package lk.tech.moondb.controller;

import jakarta.validation.Valid;
import lk.tech.moondb.dto.GroupDto;
import lk.tech.moondb.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/user/{userId}")
    public GroupDto create(@PathVariable Long userId, @Valid @RequestBody GroupDto groupDto) {
        return groupService.create(userId, groupDto);
    }

    @GetMapping("/user/{userId}")
    public List<GroupDto> getByUser(@PathVariable Long userId) {
        return groupService.getByUser(userId);
    }

    @GetMapping("/{id}")
    public GroupDto get(@PathVariable Long id) {
        return groupService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }
}