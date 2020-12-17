package org.levelup.univers.hibernate.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.levelup.univers.hibernate.domain.UniversityEntity;

import java.util.Collection;

@RequiredArgsConstructor //конструктор только с финальными полями
public class HibernateUniversityRepository implements
        UniversityRepository {

    private final SessionFactory factory;

    @Override
    public UniversityEntity createUniversity(String name, String shortName, int foundationYear) {
        try (Session s = factory.openSession()) {
            Transaction transaction = s.beginTransaction();

            UniversityEntity university = new UniversityEntity(name, shortName, foundationYear);
            s.persist(university);

            transaction.commit();

            return university;
        }

    }

    @Override
    public UniversityEntity findById(int universityId) {
        try (Session s = factory.openSession()) {
            //!! search for PKey      s.get(UniversityEntity.class, universityId)
            return s.createQuery("from UniversityEntity where id = :id", UniversityEntity.class)  //java field name!!!
                    .setParameter("id", universityId)
                    .getSingleResult();   //mehrdeutig - try catch
        }
    }

    @Override
    public Collection <UniversityEntity> findAll() { //todo
        try (Session s = factory.openSession()) {
            return s.createQuery("from UniversityEntity ", UniversityEntity.class)  //java field name!!!
                    .getResultList();
        }
    }

    @Override
    public UniversityEntity findByName(String name) {
        try (Session s = factory.openSession()) {

            return s.createQuery("from UniversityEntity where name = :name", UniversityEntity.class)  //java field
                    .setParameter("name", name)
                    .getSingleResult();
        }
    }

    @Override
    public UniversityEntity findByShortName(String shortName) {
        try (Session s = factory.openSession()) {

            return s.createQuery("from UniversityEntity where short_name = :shortname",
                                 UniversityEntity.class)  //java field
                    .setParameter("shortname", shortName)
                    .getSingleResult();
        }
    }

    @Override
    public Collection <UniversityEntity> findByFoundationYear(int foundationYear) {
        try (Session s = factory.openSession()) {
            return s.createQuery("from UniversityEntity where foundation_year = :foundationYear",
                                 UniversityEntity.class)  //java field
                    .setParameter("foundationYear", foundationYear)
                    .getResultList();
        }
    }

    @Override
    public Collection <UniversityEntity> findAllFoundedUniversitiesBetweenYears(int yearStart, int yearEnd) {
        try (Session s = factory.openSession()) {
            return s.createQuery("from UniversityEntity where foundation_year between" +
                                         "yearStart = :yearStart and yearEnd = :yearEnd",
                                 UniversityEntity.class)  //java field
                    .setParameter("yearStart", yearStart)
                    .setParameter("yearEnd", yearEnd)
                    .getResultList();
        }
    }
}