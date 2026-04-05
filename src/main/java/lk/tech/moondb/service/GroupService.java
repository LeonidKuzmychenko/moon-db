package lk.tech.moondb.service;

import lk.tech.moondb.dto.GroupDto;
import lk.tech.moondb.entity.Group;
import lk.tech.moondb.entity.User;
import lk.tech.moondb.mapper.GroupMapper;
import lk.tech.moondb.repository.GroupRepository;
import lk.tech.moondb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final GroupMapper groupMapper;

    public GroupDto create(Long userId, GroupDto groupDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Group group = groupMapper.toEntity(groupDto);
        group.setUser(user);
        return groupMapper.toDto(groupRepository.save(group));
    }

    public List<GroupDto> getByUser(Long userId) {
        return groupMapper.toDtoList(groupRepository.findByUserId(userId));
    }

    public GroupDto get(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        return groupMapper.toDto(group);
    }

    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}