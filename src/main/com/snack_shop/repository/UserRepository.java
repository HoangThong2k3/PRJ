package com.snack_shop.repository;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.snack_shop.dto.request.user.LoginRequestDto;
import com.snack_shop.dto.request.user.RegisterRequestDto;
import com.snack_shop.dto.request.user.UpdateRequestDto;
import com.snack_shop.dto.response.user.UserResponseDto;
import com.snack_shop.enums.UserRole;
import com.snack_shop.utils.DBUtils;
import com.snack_shop.utils.HashTokenGenerator;

public class UserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users"
        + "  (first_name, last_name, username, password, phone, email, role_id, avatar, address) "
        + "VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String CHECK_DUPLICATE_USER = "select * from users where username = ? or email = ? or phone = ?";
    private static final String VALIDATE_LOGIN = "select * from users where username = ? and password = ?";
    private static final String GET_ALL_USERS = "select * from users";
    private static final String GET_USER_BY_NAME = "select * from users where first_name like ? or last_name like ?";
    private static final String DELETE_USER = "delete from users where username = ?";
    private static final String UPDATE_USER  = "update users set first_name = ?, last_name = ?, email = ?, address = ?, phone = ?, avatar = ? where username = ?";
    private static final String UPDATE_USER_PASSWORD = "update users set password = ? where username = ?";

    public boolean registerUser(RegisterRequestDto user) throws SQLException {
        PreparedStatement preparedStatementCheck = null;
        try (Connection connection = DBUtils.getConnection()) {
            preparedStatementCheck = connection.prepareStatement(CHECK_DUPLICATE_USER);
            preparedStatementCheck.setString(1, user.getUsername());
            preparedStatementCheck.setString(2, user.getEmail());
            preparedStatementCheck.setString(3, user.getPhone());
            ResultSet rs = preparedStatementCheck.executeQuery();
            if (rs.next()) {
                return false;
            }
            String hashedPassword = HashTokenGenerator.generateHashToken(user.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, hashedPassword);
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setInt(7, user.getRole().ordinal());
            preparedStatement.setString(8, "default.jpg");
            preparedStatement.setString(9, "Earth");
            System.out.println(preparedStatement);
            System.out.println(user);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public UserResponseDto validateLogin(LoginRequestDto user) throws SQLException {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_LOGIN)) {

            String hashedPassword = HashTokenGenerator.generateHashToken(user.getPassword());
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashedPassword);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                System.out.println("User found!");
                return new UserResponseDto (
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("avatar"),
                    UserRole.values()[rs.getInt("role_id")]
                );
            }
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<UserResponseDto> getAllUsers(String searchValue) {
        List<UserResponseDto> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try (Connection connection = DBUtils.getConnection()) {
            if (searchValue == null || searchValue.isEmpty()) {
                preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            } else {
                preparedStatement = connection.prepareStatement(GET_USER_BY_NAME);
                preparedStatement.setString(1, "%"+ searchValue +"%");
                preparedStatement.setString(2, "%"+ searchValue +"%");
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                UserResponseDto user = new UserResponseDto(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("avatar"),
                    UserRole.values()[rs.getInt("role_id")]
                );
                users.add(user);
            }
            preparedStatement.close();
            return users;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return null;
    }

    public List<UserResponseDto> getUserByName(String name) {
        List<UserResponseDto> users = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
            preparedStatement.setString(1, "%"+ name +"%");
            preparedStatement.setString(2, "%"+ name +"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                UserResponseDto user = new UserResponseDto(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("avatar"),
                    UserRole.values()[rs.getInt("role_id")]
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return null;
    }

    public boolean deleteUser(String username) {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setString(1, username);

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return false;
    }

    public boolean updateUser(UpdateRequestDto user) {
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement;
            if (!user.getPassword().isEmpty() || user.getPassword() != "") {
                String hashedPassword = HashTokenGenerator.generateHashToken(user.getPassword());
                preparedStatement = connection.prepareStatement(UPDATE_USER_PASSWORD);
                preparedStatement.setString(1, hashedPassword);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            }
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getAvatar());
            preparedStatement.setString(7, user.getUsername());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
