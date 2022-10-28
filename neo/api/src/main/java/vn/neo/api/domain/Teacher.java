package vn.neo.api.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Teacher.
 */
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "teacher_code")
    private String teacher_code;

    @Column(name = "exp")
    private Integer exp;

    @OneToOne(optional = false)
    @NotNull
    @MapsId
    @JoinColumn(name = "id")
    private User onetomany;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher id(Long id) {
        this.id = id;
        return this;
    }

    public String getTeacher_code() {
        return this.teacher_code;
    }

    public Teacher teacher_code(String teacher_code) {
        this.teacher_code = teacher_code;
        return this;
    }

    public void setTeacher_code(String teacher_code) {
        this.teacher_code = teacher_code;
    }

    public Integer getExp() {
        return this.exp;
    }

    public Teacher exp(Integer exp) {
        this.exp = exp;
        return this;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public User getOnetomany() {
        return this.onetomany;
    }

    public Teacher onetomany(User user) {
        this.setOnetomany(user);
        return this;
    }

    public void setOnetomany(User user) {
        this.onetomany = user;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Teacher)) {
            return false;
        }
        return id != null && id.equals(((Teacher) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Teacher{" +
            "id=" + getId() +
            ", teacher_code='" + getTeacher_code() + "'" +
            ", exp=" + getExp() +
            "}";
    }
}
