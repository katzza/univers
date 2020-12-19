package org.levelup.univers.hibernate.repository;

import org.levelup.univers.hibernate.domain.SubjectEntity;

public interface SubjectRepositary {
    public SubjectEntity createSubject (Integer id, String subject, int hours);
}
