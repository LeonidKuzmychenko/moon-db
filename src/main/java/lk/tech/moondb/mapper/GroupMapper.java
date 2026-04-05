package lk.tech.moondb.mapper;

import lk.tech.moondb.dto.GroupDto;
import lk.tech.moondb.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {AreaMapper.class})
public interface GroupMapper {

    GroupDto toDto(Group group);

    Group toEntity(GroupDto groupDto);

    List<GroupDto> toDtoList(List<Group> groups);
}
