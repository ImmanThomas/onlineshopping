package com.immanuel.shoppingbackend.daoimpl;

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

	@Override

	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		
		String queryString="FROM Category where active = :active";
		Query query=sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean update(Category category) {

		try {

			sessionFactory.getCurrentSession().update(category);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

}
