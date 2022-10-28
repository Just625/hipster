package vn.neo.api.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.neo.api.domain.Teacher;
import vn.neo.api.repository.TeacherRepository;
import vn.neo.api.repository.UserRepository;
import vn.neo.api.service.TeacherService;
import vn.neo.api.service.dto.TeacherDTO;
import vn.neo.api.service.mapper.TeacherMapper;

/**
 * Service Implementation for managing {@link Teacher}.
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    private final UserRepository userRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper, UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.userRepository = userRepository;
    }

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("Request to save Teacher : {}", teacherDTO);
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        Long userId = teacherDTO.getOnetomany().getId();
        userRepository.findById(userId).ifPresent(teacher::onetomany);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public Optional<TeacherDTO> partialUpdate(TeacherDTO teacherDTO) {
        log.debug("Request to partially update Teacher : {}", teacherDTO);

        return teacherRepository
            .findById(teacherDTO.getId())
            .map(
                existingTeacher -> {
                    teacherMapper.partialUpdate(existingTeacher, teacherDTO);

                    return existingTeacher;
                }
            )
            .map(teacherRepository::save)
            .map(teacherMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TeacherDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Teachers");
        return teacherRepository.findAll(pageable).map(teacherMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TeacherDTO> findOne(Long id) {
        log.debug("Request to get Teacher : {}", id);
        return teacherRepository.findById(id).map(teacherMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Teacher : {}", id);
        teacherRepository.deleteById(id);
    }
}
