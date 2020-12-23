package org.levelup.univers.hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject_info")
public class SubjectInfoEntity {
    @Id
    @Column(name ="subject_id")
    private Integer subjectId;
    private String description;
    @Column(name = "room_number")
    private Integer roomNumber;
}
