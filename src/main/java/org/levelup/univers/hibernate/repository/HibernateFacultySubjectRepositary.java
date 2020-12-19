package org.levelup.univers.hibernate.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.levelup.univers.hibernate.domain.FacultyEntity;
import org.levelup.univers.hibernate.domain.SubjectEntity;

@RequiredArgsConstructor
public class HibernateFacultySubjectRepositary implements FacultySubjectRepositary{
    private final SessionFactory factory;

    public void waeveSubjectAndFaculty(Integer subjectId, Integer facultyId){
        try (Session s = factory.openSession()){
            SubjectEntity subject = s.get(SubjectEntity.class, subjectId);
            FacultyEntity faculty = s.get(FacultyEntity.class, facultyId);

            subject.getFaculties().add(faculty);
          //  faculty.getFacultyId().add(subject);


        }



    }
}
