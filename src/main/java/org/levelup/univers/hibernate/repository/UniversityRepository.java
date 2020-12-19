package org.levelup.univers.hibernate.repository;

import org.levelup.univers.hibernate.domain.UniversityEntity;

import java.util.Collection;

public interface UniversityRepository {
    UniversityEntity createUniversity(String name, String shortName, int foundationYear);

    UniversityEntity createUniversity(String name, String shortName, int foundationYear, int facultyId,
                                      String facultyName);

    UniversityEntity findById(int universityId);

    Collection <UniversityEntity> findAll();

    //HW
    UniversityEntity findByName(String name);

    UniversityEntity findByShortName(String shortName);

    Collection <UniversityEntity> findByFoundationYear(int foundationYear);

    Collection <UniversityEntity> findAllFoundedUniversitiesBetweenYears(int yearStart, int yearEnd);
}
