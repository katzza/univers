package org.levelup.univers.hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "faculty")
public class FacultyEntity {

    @Id
    @Column(name = "faculty_id")
    private Integer facultyId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityEntity university;

    @ManyToMany
    @JoinTable(
            name = "faculty_subject",
            joinColumns = @JoinColumn (name = "faculty_id"),     //фак_сабж фкей которой направлен на текщую таблицу
            inverseJoinColumns =  @JoinColumn (name = "subject_id")     //колонка, кот указ на 2. таблицу
    )
    private Collection <SubjectEntity> subjects;

}
