package com.shop.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shop.cafe.dao.ProductDao;
import com.shop.cafe.dto.Product;

@Service	//Component라고 해도 된다. 개발자를 위한 배려. => Service Component임을 알려준다.
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllProducts() throws Exception {
		return productDao.getAllProducts();
	}

}
