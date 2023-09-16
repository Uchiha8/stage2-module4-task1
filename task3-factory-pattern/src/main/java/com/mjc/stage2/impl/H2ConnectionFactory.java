package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection connection = null;
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("h2database");
            Class.forName(resourceBundle.getString("jdbc_driver"));
            connection = DriverManager.getConnection(resourceBundle.getString("db_url"), resourceBundle.getString("user"), resourceBundle.getString("password"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}

