package entity;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "student", schema = "qlsvv", catalog = "")
public class StudentEntity {
    private String id;
    private String fullName;
    private Boolean gender;
    private ClassDTO clazzByClassId;

    public StudentEntity() {
    }

    public StudentEntity(String id, String fullName, Boolean gender, ClassDTO clazzByClassId) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.clazzByClassId = clazzByClassId;
    }

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 45)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, gender);
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false, table = "student")
    public ClassDTO getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(ClassDTO clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }
}
