package lk.tech.moondb.controller;

import lk.tech.moondb.entity.Group;
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
    public Group create(@PathVariable Long userId, @RequestBody Group group) {
        return groupService.create(userId, group);
    }

    @GetMapping("/user/{userId}")
    public List<Group> getByUser(@PathVariable Long userId) {
        return groupService.getByUser(userId);
    }

    @GetMapping("/{id}")
    public Group get(@PathVariable Long id) {
        return groupService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }
}