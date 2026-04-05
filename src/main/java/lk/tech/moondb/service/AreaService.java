package lk.tech.moondb.service;

import lk.tech.moondb.entity.Area;
import lk.tech.moondb.entity.Group;
import lk.tech.moondb.repository.AreaRepository;
import lk.tech.moondb.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;
    private final GroupRepository groupRepository;

    public Area create(Long groupId, Area area) {
        if (areaRepository.existsById(area.getId())) {
            throw new RuntimeException("Area already exists");
        }

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        area.setGroup(group);
        return areaRepository.save(area);
    }

    public List<Area> getByGroup(Long groupId) {
        return areaRepository.findByGroupId(groupId);
    }

    public void delete(Long id) {
        areaRepository.deleteById(id);
    }
}