package lk.tech.moondb.mapper;

import lk.tech.moondb.dto.GroupCreateRequest;
import lk.tech.moondb.dto.GroupDto;
import lk.tech.moondb.entity.Group;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {AreaMapper.class})
public interface GroupMapper {

    GroupDto toDto(Group group);

    Group toEntity(GroupDto groupDto);

    Group toEntity(GroupCreateRequest request);

    List<GroupDto> toDtoList(List<Group> groups);

    @AfterMapping
    default void linkAreas(@MappingTarget Group group) {
        if (group.getAreas() != null) {
            group.getAreas().forEach(area -> area.setGroup(group));
        }
    }
}
