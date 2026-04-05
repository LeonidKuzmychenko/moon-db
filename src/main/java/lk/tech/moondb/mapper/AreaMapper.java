package lk.tech.moondb.mapper;

import lk.tech.moondb.dto.AreaDto;
import lk.tech.moondb.entity.Area;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AreaMapper {

    AreaDto toDto(Area area);

    Area toEntity(AreaDto areaDto);

    List<AreaDto> toDtoList(List<Area> areas);
}
