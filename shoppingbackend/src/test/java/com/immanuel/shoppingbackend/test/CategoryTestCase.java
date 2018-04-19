package com.immanuel.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.immanuel.shoppingbackend.dao.CategoryDAO;
import com.immanuel.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.immanuel.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * Testing add category
	 */
	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Washing Machine");
	 * category.setDescription("This is some description for WashingMachine!");
	 * category.setImageURL("CAT_105.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * Testing get category
	 */
	/*
	 * @Test public void testGetCategory() { Category category =
	 * categoryDAO.get(2);
	 * assertEquals("Succesfully fetched a single record from datavbase table",
	 * "TV", category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() { Category category =
	 * categoryDAO.get(2);
	 * 
	 * category.setName("Television");
	 * 
	 * assertEquals("Updating a record in the database", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { Category category
	 * =categoryDAO.get(2);
	 * assertEquals("Deleting a record from the database",true,categoryDAO.
	 * delete(category)); }
	 */
	
/*	@Test
	public void testListCategory(){
		
		assertEquals("Getting list of categories from database", 2,categoryDAO.list().size());
	}*/
	
	
	
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());		
				
		
	}

}
