package com.immanuel.shoppingbackend.dao;

import java.util.List;

import com.immanuel.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	
	List<Category> list();
	boolean add(Category category);
	Category get(int id);

	
	
}
