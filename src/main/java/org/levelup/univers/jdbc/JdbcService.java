package org.levelup.univers.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcService {
    public Connection openConnection() throws SQLException {
        //JDBC url:
        //jbdc: <vendor_name>://<url>:<port>/<DBname>
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/university", "postgres", "root");
    }
}
