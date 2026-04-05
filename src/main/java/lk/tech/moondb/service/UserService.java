package lk.tech.moondb.service;

import lk.tech.moondb.dto.UserDto;
import lk.tech.moondb.entity.User;
import lk.tech.moondb.mapper.UserMapper;
import lk.tech.moondb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setAuthId(UUID.randomUUID().toString());//TODO тут должен быть Auth сервер
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    public List<UserDto> getAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}