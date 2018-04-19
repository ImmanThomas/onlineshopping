package com.immanuel.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.immanuel.shoppingbackend.dao.CategoryDAO;
import com.immanuel.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories=new ArrayList<Category>();
	static {
		
		Category category =new Category();
		category.setId(1);
		category.setName("TV");
		category.setDescription("this is a tv");
		category.setImageURL("cat_10.png");
		category.setActive(true);
		
		categories.add(category);
		
	}

	@Override

	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}



	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
