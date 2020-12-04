package org.levelup.univers.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class FacultyJdbcStorage {                             // Storage Место хранения

    public JdbcService jdbcService;

    public FacultyJdbcStorage() {
        this.jdbcService = new JdbcService();
    }

    public void createFaculty(String name, int university_id) {
        checkUniversity_id(university_id);
        try (Connection connection = jdbcService.openConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into faculty (name , university_id) " +
                                                                              "values ( ?, ?) ");
            statement.setString(1, name);
            statement.setInt(2, university_id);
            int rowAffected = statement.executeUpdate(); //используется для insert/update/delete
            System.out.println("Rows affected = " + rowAffected);
        } catch (
                SQLException exc) {
            System.out.println(exc.getMessage());
            throw new RuntimeException();
        }
    }

    private void checkUniversity_id(int university_id) {
        UniversJdbcStorage storage = new UniversJdbcStorage();
        HashMap universityById = storage.findBySql("select * from university where id =?", university_id);
        if (!(universityById.size() == 4)) {
            throw new IllegalArgumentException("university_id is incorrect - it's absent in the table university");
        }
    }

}
