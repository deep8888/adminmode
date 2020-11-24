package com.poi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.poi.model.Product;

@Repository
public class ProductDao {
	// dao가 jdbc템플릿사용할때 dataSource를 주입을 받아야해
	private JdbcTemplate jdbcTemplate;

	// @Autowired라는게 xml에서 같은 타입이 있으면 묶어주는거임.
	// dao-context.xml에 <bean id="dataSource" 요로케 되어있는게 있음
	// 이게 주입되는거임.
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// 실질적으로 jdbcTemplate가 생성되는곳, 생성된 템플릿은 컨테이너가 관리하지는 않음
		// dao-context.xml에 <bean id="dataSource" 이 부분이 datasource에 들어가면서 생성
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Product> getProducts() {
		// db에서 쿼리를 진행할 sql문을 만들었다.

		String sqlStatement = "select * from estore.product";
		// 레코드 형태로 들어오는데 그거를 object 형식으로 바꿔줘야함.
		// 그걸 RowMapper의 mapRow함수가 해
		return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {
			
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

				Product product = new Product();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setManufacturer(rs.getString("manufacturer"));
				product.setUnitInStock(rs.getInt("unitInStock"));
				product.setDescription(rs.getString("description"));
				System.out.println(product);
				return product;
			}
			
		});
	}
}
