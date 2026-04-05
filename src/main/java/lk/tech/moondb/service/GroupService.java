package lk.tech.moondb.service;

import lk.tech.moondb.entity.Group;
import lk.tech.moondb.entity.User;
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

    public Group create(Long userId, Group group) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        group.setUser(user);
        return groupRepository.save(group);
    }

    public List<Group> getByUser(Long userId) {
        return groupRepository.findByUserId(userId);
    }

    public Group get(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }

    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}