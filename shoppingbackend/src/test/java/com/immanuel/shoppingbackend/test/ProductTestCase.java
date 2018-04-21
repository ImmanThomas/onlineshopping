package com.immanuel.shoppingbackend.test;



import static org.junit.Assert.assertEquals;

import java.util.List;

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
	/*@Test
	public void listProductTest()
	{
		assertEquals("unable to get all the values of the product",5,productDAO.list().size());
	}*/
	/*@Test
	public void addProductTest()
	{
		 product=new Product();
		 product.setName("Pixel 2");
		 product.setBrand("Google");
		 product.setDescription("world's best camera phone");
		 product.setUnitPrice(80000);
		 product.setQuantity(3);
		 product.setActive(true);
		 product.setCategoryID(3);
		 product.setSupplierID(3);
		 product.setPurchases(0);
		 product.setViews(0);
		
		assertEquals("Unable to add the product to the database",true,productDAO.add(product));
	}*/
	
	/*@Test
	public void updateProductTest()
	{
		product=productDAO.get(34);
		product.setName("pixel  2");
		assertEquals("unable to update the product to the database",true,productDAO.update(product));
	}*/
	
	/*@Test
	public void deleteProductTest(){
		product=productDAO.get(34);

		assertEquals("unable to delete the product to the database",true,productDAO.delete(product));
	}*/
	
	@Test
	public void getActiveProductsTest()
	{
		assertEquals("unable to fetch all the active products",5,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void getActiveProductsByCategoryTest()
	{
		assertEquals("unable to fetch all the active products",3,productDAO.listActiveProductsByCategory(3).size());
	}
	@Test
	public void getLatestActiveProducts()
	{
		List<Product> latestActiveProducts=productDAO.getLatestActiveProducts(3);
		System.out.println("imman**"+latestActiveProducts);
		assertEquals("unable to fetch the latest active products",3,latestActiveProducts.size());
	}

}
