package lk.tech.moondb.controller;

import lk.tech.moondb.dto.AreaDto;
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
    public AreaDto create(@PathVariable Long groupId, @RequestBody AreaDto areaDto) {
        return areaService.create(groupId, areaDto);
    }

    @GetMapping("/group/{groupId}")
    public List<AreaDto> getByGroup(@PathVariable Long groupId) {
        return areaService.getByGroup(groupId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        areaService.delete(id);
    }
}