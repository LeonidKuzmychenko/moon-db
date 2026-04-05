package lk.tech.moondb.controller;

import lk.tech.moondb.entity.Area;
import lk.tech.moondb.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @PostMapping("/group/{groupId}")
    public Area create(@PathVariable Long groupId, @RequestBody Area area) {
        return areaService.create(groupId, area);
    }

    @GetMapping("/group/{groupId}")
    public List<Area> getByGroup(@PathVariable Long groupId) {
        return areaService.getByGroup(groupId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        areaService.delete(id);
    }
}