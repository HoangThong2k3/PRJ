package com.snack_shop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.snack_shop.dto.request.user.RegisterRequestDto;
import com.snack_shop.utils.DBUtils;
import org.mindrot.jbcrypt.BCrypt;

public class UserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users"
        + "  (username, password, status, firstName, lastName) VALUES " + " (?, ?, ?, ?, ?);";
    private static final String VALIDATE_LOGIN = "select * from users where username = ? and status = ?";

    public boolean registerUser(RegisterRequestDto user) throws SQLException {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashPassword);
            preparedStatement.setInt(3, UserStatus.ACTIVE.ordinal());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return false;
    }

    public LoginResponseDto validateLogin(LoginRequestDto user) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_LOGIN)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setInt(2, UserStatus.ACTIVE.ordinal());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (BCrypt.checkpw(user.getPassword(), rs.getString("password"))) {
                    return new LoginResponseDto(rs.getInt("id"), rs.getString("username"), UserStatus.ACTIVE,
                        rs.getString("lastName"), rs.getString("firstName"));
                }
            }
        } catch (SQLException e) {
            DBUtil.printSQLException(e);
        }
        return null;
    }

}
