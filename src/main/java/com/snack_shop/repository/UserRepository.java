package com.snack_shop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.snack_shop.dto.request.user.LoginRequestDto;
import com.snack_shop.dto.request.user.RegisterRequestDto;
import com.snack_shop.dto.response.user.UserDto;
import com.snack_shop.enums.UserRole;
import com.snack_shop.utils.DBUtils;
import org.mindrot.jbcrypt.BCrypt;

public class UserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users"
        + "  (first_name, last_name, username, password, phone, email, role_id) VALUES " + " (?, ?, ?, ?, ?);";
    private static final String VALIDATE_LOGIN = "select * from users where username = ? and password = ?";
    private static final String GET_ALL_USERS = "select * from users";

    public boolean registerUser(RegisterRequestDto user) throws SQLException {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, hashPassword);
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setInt(7, user.getRole().ordinal());

            System.out.println(preparedStatement);
            System.out.println(user);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return false;
    }

    public UserDto validateLogin(LoginRequestDto user) throws SQLException {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_LOGIN)) {
            preparedStatement.setString(1, user.getUsername());
            String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
            preparedStatement.setString(2, hashPassword);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new UserDto(
                    rs.getInt("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("avatar"),
                    UserRole.values()[rs.getInt("role")]
                );
            }
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return null;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                UserDto user = new UserDto(
                    rs.getInt("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("avatar"),
                    UserRole.values()[rs.getInt("role")]
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return null;
    }
}
