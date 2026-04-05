package lk.tech.moondb.service;

import lk.tech.moondb.dto.AreaCreateRequest;
import lk.tech.moondb.dto.AreaDto;
import lk.tech.moondb.entity.Area;
import lk.tech.moondb.entity.Group;
import lk.tech.moondb.mapper.AreaMapper;
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
    private final AreaMapper areaMapper;

    public AreaDto create(Long groupId, AreaCreateRequest request) {
        if (areaRepository.existsById(request.getId())) {
            throw new RuntimeException("Area already exists");
        }

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        Area area = areaMapper.toEntity(request);
        area.setGroup(group);
        return areaMapper.toDto(areaRepository.save(area));
    }

    public List<AreaDto> getByGroup(Long groupId) {
        return areaMapper.toDtoList(areaRepository.findByGroupId(groupId));
    }

    public void delete(Long id) {
        areaRepository.deleteById(id);
    }
}