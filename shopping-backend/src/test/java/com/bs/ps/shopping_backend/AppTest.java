package com.bs.ps.shopping_backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs.ps.dao.CategoryDao;
import com.bs.ps.dto.Category;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	
@BeforeClass
public static void init()
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.bs.ps");
	context.refresh();
	categoryDao= (CategoryDao)context.getBean("categorydao");
}

@Test
public void test()
{
	assertEquals("success",3,categoryDao.getCategory().size());
}
}
