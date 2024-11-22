package com.tka.NimapMachineTest.Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.NimapMachineTest.entity.Category;
import com.tka.NimapMachineTest.entity.Product;

@Repository
public class MainDao {
	@Autowired
    SessionFactory factory;
	public String addCategory(Category c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
		
		session=factory.openSession();
		tx=session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="Category Added Successfully...";
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			
			if(session!=null) {
				session.close();
			}
			
		}
	return msg;	
	}
	
	
	
	
	public String updateCategory(Category c, int id) {
		Session session=null;
		Transaction tx=null;
		String msg= null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Category category=session.get(Category.class, id);
			category.setCname(c.getCname());
			session.merge(category);
			tx.commit();
			msg="Category is updated";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			
			if(session!=null) {
				session.close();
			}
			
		}
	return msg;	
	}

		
	
	
	public String deleteCategory(int cid) {
			Session session= null;
			Transaction tx= null;
			String msg= null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				Category category= session.get(Category.class,cid);
				session.remove(category);
				tx.commit();
				msg="Category is deleted";
				
			}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
			}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
					
			}
			}
			return msg;
		}

		
	
	public List<Category> getAllRecord(int page, int size) {
			Session session= null;
			Transaction tx= null;
			List<Category>list=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				String hqlQuery="from Category";
				
				Query<Category> query=session.createQuery(hqlQuery,Category.class);
				query.setFirstResult(page*size);
				query.setMaxResults(size);
				list=query.list();
				tx.commit();
				
			}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
			}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
					
			}
			}
			return list;
		}

	
	
	public Category getparticularCategoryById(int cid) {
			Session session= null;
			Transaction tx= null;
			Category category=null;
			
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				category=session.get(Category.class, cid);
				tx.commit();
				
			}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
			}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
					
			}
			}
			return category;
		}
		
		
	
	public String addProduct(Product product) {
			Session session= null;
			Transaction tx= null;
			String msg=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				session.persist(product);
				tx.commit();
				msg="product added successfully";
			}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
			}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
					
			}
			}
			return msg;
		}

	
	
	public String updateProduct(int id) {
			Session session=null;
			Transaction tx=null;
			String msg= null;
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				Product product=session.get(Product.class, id);
				product.setPname(product.getPname());
				
				session.merge(product);
				tx.commit();
				msg="product is updated";
				
			}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
			}finally {
				
				
				if(session!=null) {
					session.close();
				}
				
			}
		return msg;	
		}

	
	
	public String deleteProduct(int id) {	
			Session session= null;
			Transaction tx= null;
			String msg= null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				Product product= session.get(Product.class,id);
				session.remove(product);
				tx.commit();
				msg="employee is product";
				
			}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
			}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
					
			}
			}
			return msg;
		}

		
	
	public List<Product> getAllProduct(int page,int size) {
			Session session=null;
			Transaction tx= null;
	        List<Product>list=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				String hqlQuery="from Product";
				
				Query<Product> query=session.createQuery(hqlQuery,Product.class);
				query.setFirstResult(page*size);
				query.setMaxResults(size);
				list=query.list();
				tx.commit();
				
			}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
			}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
					
			}
			}
			return list;
		}

		
	
	  
	public Product getPerticularProduct(int id) {
			Session session= null;
			Transaction tx= null;
			Product product=null;
			
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				product=session.get(Product.class, id);
				tx.commit();
				
			}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
			}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
					
			}
			}
			return product;
		}

	
	
	public Product loginCheck(Product p) {
			Session session= null;
			Transaction tx= null;
			Product product=null;
			
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				String hqlQuery="from Employee where emailid=:emailid and mobno=:mobno";
				
				Query<Product> query=session.createQuery(hqlQuery);
				query.setParameter("pname",p.getPname());
				query.setParameter("pprice", p.getPprice());
				product=query.uniqueResult();
				tx.commit();
				
		}catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
			}
				e1.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
					
			}
			}
			return product;
		}



}
