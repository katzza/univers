package org.levelup.utils.hibernate;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.levelup.univers.hibernate.repository.HibernateUniversityRepository;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

public class HibernateUniversityRepositoryTest {
    private HibernateUniversityRepository hibernateUniversityRepository;
    @Mock
    private SessionFactory factory;

    @BeforeEach
    public void setupHibernateUniversityRepository() throws SQLException {
        MockitoAnnotations.openMocks(this);
    //    hibernateUniversityRepository = new HibernateUniversityRepository(hibernateUniversityRepository);

  /*      Mockito.when(jdbcService.openConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(ArgumentMatchers.anyString()))
               .thenReturn(statement);*/
    }

}
