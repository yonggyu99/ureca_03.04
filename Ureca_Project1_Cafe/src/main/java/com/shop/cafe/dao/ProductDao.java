package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.shop.cafe.dto.Product;

@Component	//DI를 이용을 위해 사용 SpringBoot에서 new할 수 있게 Component로 만들어준다.
public class ProductDao {
	
	public List<Product> getAllProducts() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/ureca ? serverTimezone = UTC";
		String user = "ureca";
		String pw = "ureca";
		
		String sql = "select * from product";
		
		try(
			Connection con = DriverManager.getConnection(url, user, pw);
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
				){
			
			List<Product> list = new ArrayList();
			
			while(rs.next()) {
				
				int prodcode = rs.getInt("prodcode");
				String prodname = rs.getString("prodname");
				String pimg = rs.getString("pimg");
				int price = rs.getInt("price");
				
				list.add(new Product(prodcode, price, prodname, pimg));
			}
			
			return list;
			
			
			
		}
		
		
	}

}
