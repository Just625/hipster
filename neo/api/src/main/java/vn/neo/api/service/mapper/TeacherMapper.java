package vn.neo.api.service.mapper;

import org.mapstruct.*;
import vn.neo.api.domain.*;
import vn.neo.api.service.dto.TeacherDTO;

/**
 * Mapper for the entity {@link Teacher} and its DTO {@link TeacherDTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface TeacherMapper extends EntityMapper<TeacherDTO, Teacher> {
    @Mapping(target = "onetomany", source = "onetomany", qualifiedByName = "login")
    TeacherDTO toDto(Teacher s);
}
