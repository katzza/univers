package org.levelup.utils.universities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.levelup.univers.jdbc.JdbcService;
import org.levelup.univers.jdbc.UniversJdbcStorage;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

public class UniversitiesJbdsStorageTest {

    private UniversJdbcStorage jdbcStorage;
    @Mock
    private JdbcService jdbcService;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement statement;
    @Mock
    private UniversJdbcStorage universJdbcStorage;

    //1 variant
    @BeforeEach
    public void setupJdbcStorage() throws SQLException {
        MockitoAnnotations.openMocks(this);
        //  1 variant
        //jdbcService = Mockito.mock(JdbcService.class);
        jdbcStorage = new UniversJdbcStorage(jdbcService);
        Mockito.when(jdbcService.openConnection())
               .thenReturn(connection);
        Mockito.when(connection.prepareStatement(ArgumentMatchers.anyString()))
               .thenReturn(statement);
    }

    @Test
    public void testCreateUniversity_whenDataisvalid_thenCreateUniversity() throws SQLException {
        //given
        String name = "name";
        String shortname = "short name";
        int foundationYear = 1974;
        Mockito.when(statement.executeUpdate()).thenReturn(10);
        //when
        jdbcStorage.createUniversity(name, shortname, foundationYear);
        //then
        Mockito.verify(statement).executeUpdate();
        Mockito.verify(statement, Mockito.times(2))
               .setString(ArgumentMatchers.anyInt(), ArgumentMatchers.anyString());
        Mockito.verify(statement).setInt(3, foundationYear);

    }

    @Test
    public void testCreateUniversity_whenDataIsInvalid_thenIllegalArgumentException() throws SQLException {
        //given
        String name = "name";
        String shortname = "short name";
        int foundationYear = -1;

        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> {
            jdbcStorage.createUniversity(name, shortname, foundationYear);
        });
        assertNotNull(thrown.getMessage());

        //   doThrow().when(jdbcStorage).createUniversity(name, shortname, foundationYear);
    }

    @Test
    public void testCreateUniversity_whenDataIsInvalid_thenIllegalArgumentExceptionCheckText() throws SQLException {
        //given
        String name = "name";
        String shortname = "short name";
        int foundationYear = -1;

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                jdbcStorage.createUniversity(name, shortname, foundationYear));
        assertEquals("Year must be positive", exception.getMessage());
     }


    @Test
    public void testCreateUniversity_whenDataIsInvalid_thenIllegalArgumentExceptionOption2() throws SQLException {
        //given
        String name = "name";
        String shortname = "short name";
        int foundationYear = -2;
//todo тут не понимаю, что происходит - код Марины
        Mockito.doThrow(IllegalArgumentException.class).when(universJdbcStorage).createUniversity(name, shortname,
                                                                                                  foundationYear);
        assertThrows(IllegalArgumentException.class, () -> jdbcStorage.createUniversity("", "", -3));

        Mockito.when(jdbcService.openConnection()).thenThrow(SQLException.class);

        assertThrows(RuntimeException.class, () ->
                jdbcStorage.createUniversity("", "", 1000));
    }

    @Test
    public void testCreateUniversity_whenCouldNotOpenConnection_thenThrowException() throws SQLException {
        // given
        Mockito.when(jdbcService.openConnection()).thenThrow(SQLException.class);
        // Mockito.doThrow(SQLException.class).when(jdbcService).openConnection();
        // Mockito.doThrow(SQLException.class).when(statement).setNull(1,1);
        // where
        Assertions.assertThrows(RuntimeException.class, () ->
                jdbcStorage.createUniversity("name", "short name", 1000));
    }
}

//2 tests: 1 - foundYear<0
// 2 - runtime Esceptions = ok
//Junit 5! non-4