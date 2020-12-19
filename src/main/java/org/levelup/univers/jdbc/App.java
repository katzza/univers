package org.levelup.univers.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        UniversJdbcStorage universJdbcStorage = new UniversJdbcStorage(new JdbcService());
        FacultyJdbcStorage facultyJdbcStorage = new FacultyJdbcStorage();
        facultyJdbcStorage.updateFacultyName("hjdhdskfd", 100);
      /*  try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("name");
            String name = reader.readLine();
            System.out.println("shortName");
            String shortName = reader.readLine();
            System.out.println("year");
            int foundationYear = Integer.parseInt(reader.readLine());
            universJdbcStorage.createUniversity(name, shortName, foundationYear);
        } catch (IOException exc) {
            throw new RuntimeException();
        }*/
        //  universJdbcStorage.displayUniversities();
        //   HashMap result = universJdbcStorage.findBySql("select * from university where foundation_year >?", 1900);
        //HashMap result1 = universJdbcStorage.findBySql("select * from university where id =?", 1);
        //System.out.println();
        //       universJdbcStorage.findBySql("select * from university where short_name like ?", "'С%'");
     /*   try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("faculty name");
            String name = reader.readLine();
            System.out.println("uni id");
            int universityId = Integer.parseInt(reader.readLine());
            facultyJdbcStorage.createFaculty(name, universityId);
        } catch (IOException exc) {
            throw new RuntimeException();
        }*/
    }
}
