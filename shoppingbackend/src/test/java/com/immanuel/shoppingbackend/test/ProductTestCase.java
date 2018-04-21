package com.immanuel.shoppingbackend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.immanuel.shoppingbackend.dao.ProductDAO;
import com.immanuel.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.immanuel.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	/*@Test
	public void getProductTest(){
		Product product = productDAO.get(2);
		System.out.println(product);
		assertEquals("unable to fetch the product","samsung",product.getBrand());
	}*/

}
