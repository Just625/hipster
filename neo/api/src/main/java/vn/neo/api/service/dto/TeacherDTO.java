package vn.neo.api.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link vn.neo.api.domain.Teacher} entity.
 */
public class TeacherDTO implements Serializable {

    private Long id;

    private String teacher_code;

    private Integer exp;

    private UserDTO onetomany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacher_code() {
        return teacher_code;
    }

    public void setTeacher_code(String teacher_code) {
        this.teacher_code = teacher_code;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public UserDTO getOnetomany() {
        return onetomany;
    }

    public void setOnetomany(UserDTO onetomany) {
        this.onetomany = onetomany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TeacherDTO)) {
            return false;
        }

        TeacherDTO teacherDTO = (TeacherDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, teacherDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TeacherDTO{" +
            "id=" + getId() +
            ", teacher_code='" + getTeacher_code() + "'" +
            ", exp=" + getExp() +
            ", onetomany=" + getOnetomany() +
            "}";
    }
}
