package com.snack_shop.repository;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.enums.ProductStatus;
import com.snack_shop.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String GET_ALL_PRODUCTS = "select * from product";
    private static final String GET_PRODUCT_BY_ID = "select * from product where product_id = ?";
    private static final String GET_PRODUCTS_BY_PAGE = "SELECT * FROM product ORDER BY product_id LIMIT ? OFFSET ?";
    private static final String GET_TOP_LATEST_PRODUCTS = "SELECT * FROM product ORDER BY import_date DESC LIMIT 6";
    private static final String GET_PRODUCT_BY_NAME = "select * from product where product_name like ?";


    public List<ProductResponseDto> getAllProducts() {
        List<ProductResponseDto> products = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try (Connection connection = DBUtils.getConnection()) {
            preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ProductResponseDto product = new ProductResponseDto(
                    rs.getString("category"),
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    ProductStatus.values()[rs.getInt("status")],
                    rs.getDate("import_date")
                );
                products.add(product);
            }
            preparedStatement.close();
            return products;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return null;
    }

    public List<ProductResponseDto> getProductsByPage(int pageNumber) {

        List<ProductResponseDto> products = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        int pageSize = 6;
        int offset = (pageNumber - 1) * pageSize;

        try (Connection connection = DBUtils.getConnection()) {
            preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_PAGE);
            preparedStatement.setInt(1, pageSize);
            preparedStatement.setInt(2, offset);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ProductResponseDto product = new ProductResponseDto(
                    rs.getString("category"),
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    ProductStatus.values()[rs.getInt("status")],
                    rs.getDate("import_date")
                );
                products.add(product);
            }
            preparedStatement.close();
            return products;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return null;
    }

    public List<ProductResponseDto> getTopLatestProducts() {
        List<ProductResponseDto> products = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try (Connection connection = DBUtils.getConnection()) {
            preparedStatement = connection.prepareStatement(GET_TOP_LATEST_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ProductResponseDto product = new ProductResponseDto(
                    rs.getString("category"),
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    ProductStatus.values()[rs.getInt("status")],
                    rs.getDate("import_date")
                );
                products.add(product);
            }
            preparedStatement.close();
            return products;
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return null;
    }

    public ProductResponseDto getProductById(int productId) {
        PreparedStatement preparedStatement = null;
        try (Connection connection = DBUtils.getConnection()) {
            preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ProductResponseDto product = new ProductResponseDto(
                    rs.getString("category"),
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    ProductStatus.values()[rs.getInt("status")],
                    rs.getDate("import_date")
                );
                preparedStatement.close();
                return product;
            }
        } catch (SQLException e) {
            DBUtils.printSQLException(e);
        }
        return null;
    }

}
