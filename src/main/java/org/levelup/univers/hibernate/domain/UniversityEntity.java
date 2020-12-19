package org.levelup.univers.hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "university")
public class UniversityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column (name = "short_name", nullable = false, unique = true)
    private String shortName;
    @Column (name = "foundation_year", nullable = false)
    private Integer foundationYear;
    @JoinColumn (name = "university_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List <FacultyEntity> faculties;

    @Override
    public String toString() {
        return "UniversityEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", foundationYear=" + foundationYear +
                '}';
    }

    public UniversityEntity(String name, String shortName, Integer foundationYear){
        this.name = name;
        this.shortName =shortName;
        this.foundationYear = foundationYear;
        this.faculties = new ArrayList <>();
    }
}
