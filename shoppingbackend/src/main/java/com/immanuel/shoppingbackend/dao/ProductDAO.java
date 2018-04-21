package com.immanuel.shoppingbackend.dao;

import java.util.List;

import com.immanuel.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product get(int id);

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	// Business Methods

	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryID);

	List<Product> getLatestActiveProducts(int count);

}
