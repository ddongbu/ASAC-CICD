package com.example.demo.src.user;

import com.example.demo.src.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ProductDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GetProductRes getProductDeatilById(int productId){
        String getProductQuery = "SELECT products.*, product_Detail.*\n" +
                "FROM products\n" +
                "JOIN product_Detail ON products.productid = product_Detail.products_productid\n" +
                "WHERE products.productid = ?;";
        int getProductParams = productId;
        return this.jdbcTemplate.queryForObject(getProductQuery,
                (rs, rowNum) -> new GetProductRes(
                        rs.getInt("ProductId"),
                        rs.getString("ProductName"),
                        rs.getString("ProductPrice"),
                        rs.getInt("seller_sellerid"),
                        rs.getString("ProductComment"),
                        rs.getString("ProductPhone")),
                getProductParams);
    }

    public int insertProductDetail(PostAdminProductRes postAdminProductRes){
        String insertProductDetailQuery = "INSERT INTO product_Detail(productComment, productPhone, role_id,products_productId)\n" +
                "VALUES (?,?,?,?);\n";
        Object[] insertProductdetailParams = new Object[]{postAdminProductRes.getProductComment(), postAdminProductRes.getProductPhone(), postAdminProductRes.getRole_id(),postAdminProductRes.getProducts_productId()};
        this.jdbcTemplate.update(insertProductDetailQuery, insertProductdetailParams);
        String lastInserIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInserIdQuery,int.class);
    }
}
