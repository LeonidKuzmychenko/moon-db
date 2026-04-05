package lk.tech.moondb.mapper;

import lk.tech.moondb.dto.UserCreateRequest;
import lk.tech.moondb.dto.UserDto;
import lk.tech.moondb.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {GroupMapper.class})
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    User toEntity(UserCreateRequest request);

    List<UserDto> toDtoList(List<User> users);

    @AfterMapping
    default void linkGroups(@MappingTarget User user) {
        if (user.getGroups() != null) {
            user.getGroups().forEach(group -> group.setUser(user));
        }
    }
}
