package org.levelup.univers.hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Entity
@NoArgsConstructor

@Table (name = "subject")
public class SubjectEntity {
    @Id
    private Integer id;
    private String subject;
    @Column(name = "count_of_hours")
    private Integer hours;

    @ManyToMany(mappedBy = "subjects")
    private Collection<FacultyEntity> faculties;

    public SubjectEntity (int id, String subject, int hours){
        this.id = id;
        this.subject = subject;
        this.hours = hours;
        this.faculties = new ArrayList <>();

    }
}
