package com.example.week2.repository;

import com.example.week2.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS product (
                    id INT PRIMARY KEY,
                    name VARCHAR(100),
                    price DOUBLE
                )
                """;

        jdbcTemplate.execute(sql);
    }

    public void save(Product product) {
        String sql = "INSERT INTO product (id, name, price) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM product";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );
    }
}