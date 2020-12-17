package org.levelup.univers.jdbc;

import java.sql.*;
import java.util.HashMap;

public class UniversJdbcStorage {
    public JdbcService jdbcService;

    public UniversJdbcStorage(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    public void createUniversity(String name, String shortname, int foundationYear) {
        if (foundationYear < 0) {
            throw new IllegalArgumentException("Year must be positive");
        }
        try (Connection connection = jdbcService.openConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into university (name, short_name," +
                                                                              " " +
                                                                              "foundation_year)" +
                                                                              "values ( ? , ?, ?) ");
            statement.setString(1, name);
            statement.setString(2, shortname);
            statement.setInt(3, foundationYear);
            int rowAffected = statement.executeUpdate(); //используется для insert/update/delete
            System.out.println("Rows affected = " + rowAffected);
        } catch (
                SQLException exc) {
            System.out.println(exc.getMessage());
            throw new RuntimeException();
        }
    }

    public void displayUniversities() {
        try (Connection connection = jdbcService.openConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from university");  //for select
            while (rs.next()) {
                //rs - указатель на текущую строку в цикле
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String shortname = rs.getString("short_name");
                int foundationYear = rs.getInt("foundation_year");
                System.out.println(id + " " + name + " " + shortname + " " + foundationYear);
            }
        } catch (SQLException exc) {
            System.out.println("Couldn't open new connection" + exc.getMessage());
            throw new RuntimeException(exc);
        }
    }

    public HashMap findBySql(String sql, Object... args) {  //vararg
        HashMap result = new HashMap();
        try (Connection connection = jdbcService.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            int parameterIndex = 1;
            for (Object argument : args) {statement.setObject(parameterIndex++, argument);}
            ResultSet rs = statement.executeQuery();  //для PreparedStatement  нельзя передавать строку так: statement
            // .executeQuery("select * from university");  //for select
            while (rs.next()) {
                //rs - указатель на текущую строку в цикле
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String shortName = rs.getString("short_name");
                int foundationYear = rs.getInt("foundation_year");
                System.out.println("Найден университет: " + id + " " + name + " " + shortName + " " + foundationYear);
                result.put("id", id);
                result.put("name", name);
                result.put("shortName", shortName);
                result.put("foundationYear", foundationYear);
                return result;
            }
        } catch (
                SQLException exc) {
            System.out.println(exc.getMessage());
            throw new RuntimeException();
        }
        return result;
    }
}