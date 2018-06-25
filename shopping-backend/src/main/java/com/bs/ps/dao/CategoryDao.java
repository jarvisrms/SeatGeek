package com.bs.ps.dao;

import java.util.List;

import com.bs.ps.dto.Category;

public interface CategoryDao {
	
	public List<Category> getCategory();
	
	public Category getCategoryInt(int id);

}
