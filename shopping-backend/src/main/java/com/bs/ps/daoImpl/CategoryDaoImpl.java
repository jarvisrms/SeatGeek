
package com.bs.ps.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bs.ps.dao.CategoryDao;
import com.bs.ps.dto.Category;


@Repository("categorydao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	
	public List<Category> getCategory() {
		String hql = "FROM Category WHERE is_active=:active";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("active", true);
		return query.getResultList();
		
	}

	@Override
	public Category getCategoryInt(int id) {
		// TODO Auto-generated method stu
		return sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}



}
