package com.immanuel.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.immanuel.shoppingbackend.dao.ProductDAO;
import com.immanuel.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() {

		String queryProduct = "FROM Product ";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(queryProduct);

		return query.getResultList();
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Product> listActiveProducts() {
		String queryProduct = "FROM Product where active = :active";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(queryProduct);
		query.setParameter("active", true);
		return query.getResultList();

	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryID) {
		// TODO Auto-generated method stub
		String queryProductByCatgeory = "FROM Product where active = :active AND categoryID = :categoryid";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(queryProductByCatgeory);
		query.setParameter("active", true);
		query.setParameter("categoryid", categoryID);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		String queryLatestProduct = "FROM Product where active = :active ORDER BY id desc";
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(queryLatestProduct);
		query.setParameter("active", true);

		return query.setFirstResult(0).setMaxResults(count).getResultList();
	}

}
