package com.thong.pokemon.services;

import java.sql.*;

public class UserService {

    //use mysql connector to create userService
    public UserService() {
    }

    private Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            java.lang.Class.forName(Config.JDBC_DRIVER);
            connection = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean login(String username, String password) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        ) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true; // Credentials are correct
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Credentials are incorrect
    }

}
