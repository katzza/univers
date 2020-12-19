package org.levelup.univers.hibernate.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.univers.hibernate.domain.SubjectEntity;

@RequiredArgsConstructor
public class HibernateSubjectRepositary {

    private final SessionFactory factory;

    public SubjectEntity createSubject(Integer id, String subject, int hours) {
        try (Session s = factory.openSession()) {
            Transaction t = s.beginTransaction();

            SubjectEntity subj = new SubjectEntity(id, subject, hours);
            s.persist(subj);
            t.commit();
            return subj;
        }
    }
}
