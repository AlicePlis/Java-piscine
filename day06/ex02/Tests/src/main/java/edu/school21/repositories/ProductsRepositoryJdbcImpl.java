package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements  ProductsRepository {

    private DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() {

        ArrayList<Product> allProduct = new ArrayList<>();

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM product;");

            while (res.next()) {
                allProduct.add(new Product((long)res.getInt("id"), res.getString("name"), (long)res.getDouble("price")));
            }
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allProduct;
    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            Product product = new Product();
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery("SELECT * FROM product WHERE id=" + id + ";");

            if  (res.next()) {
                product = new Product((long) res.getInt("id"), res.getString("name"), (long)res.getDouble("price"));
            }

            connection.close();
            return Optional.of(product);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            statement.execute("DELETE FROM product WHERE id="+ id + ";");
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            statement.execute(String.format("UPDATE product SET name='%s', price=%d WHERE id=%d;", product.getName(), product.getPrice(), product.getId()));
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void save(Product product) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            statement.execute(String.format("INSERT INTO product VALUES (%d, '%s', %d);", product.getId(), product.getName(), product.getPrice()));
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
