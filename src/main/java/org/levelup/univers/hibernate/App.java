package org.levelup.univers.hibernate;

import org.hibernate.SessionFactory;
import org.levelup.univers.hibernate.config.HibernateConfiguration;
import org.levelup.univers.hibernate.domain.UniversityEntity;
import org.levelup.univers.hibernate.repository.HibernateUniversityRepository;
import org.levelup.univers.hibernate.repository.UniversityRepository;

import java.util.Collection;

public class App {

    public static void main(String[] args) {
        SessionFactory factory = HibernateConfiguration.getFactory();
         UniversityRepository universityRepository = new HibernateUniversityRepository(factory);
  /*   UniversityEntity university = universityRepository
                .createUniversity("МИР-1", "М1", 1003);
    //     System.out.println("ID ЛЭТИ: " + university.getId()); */
        System.out.println( universityRepository.findByFoundationYear(1894).toString());
        System.out.println( universityRepository.findByFoundationYear(18094).toString());
        System.out.println(universityRepository.findAllFoundedUniversitiesBetweenYears(0, 2000));

        factory.close();
    }

}
