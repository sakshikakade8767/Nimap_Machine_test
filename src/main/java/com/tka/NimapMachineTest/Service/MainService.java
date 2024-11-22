package com.tka.NimapMachineTest.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.NimapMachineTest.Dao.MainDao;
import com.tka.NimapMachineTest.entity.Category;
import com.tka.NimapMachineTest.entity.Product;


@Service
public class MainService {
	@Autowired
	MainDao dao;

	public String addCategory(Category c) {
		String msg = dao.addCategory(c);
		if (Objects.isNull(msg)) {
			msg = "Category is not added";
		}
		return msg;
	}

	  
	
	public String updateCategory(Category c, int id) {
		String str = dao.updateCategory(c, id);
		if (Objects.isNull(str)) {
			str = "Category is not updated";
		}
		return str;
	}

	
	
	public String deleteCategory(int cid) {
		String str = dao.deleteCategory(cid);
		if (Objects.isNull(str)) {
			str = "Category is not deleted";
		}
		return str;
	}

	
	
	public List<Category> getAllRecord(int page , int size) {
		List<Category> list = dao.getAllRecord(page,size);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	
	
	public Category getparticularCategoryById(int cid) {
		Category category = dao.getparticularCategoryById(cid);
		if (Objects.isNull(category)) {
			category = null;
		}
		return category;
	}

	
	
	public String addProduct(Product product) {
		String msg = dao.addProduct(product);
		if (Objects.isNull(msg)) {
			msg = "Product is not added successfully";
		}

		return msg;
	}

	
	
	public String updateProduct(Product product, int id) {
		String str = dao.updateProduct(id);
		if (Objects.isNull(str)) {
			str = "Product is not updated";
		}
		return str;
	}

	
	
	public String deleteProduct(int id) {
		String str = dao.deleteProduct(id);
		if (Objects.isNull(str)) {
			str = "Product is not deleted";
		}
		return str;
	}

	
	
	public List<Product> getAllProduct(int page,int size) {
		List<Product> list = dao.getAllProduct(page,size);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	
	
	public Product getPerticularProduct(int id) {
		Product product = dao.getPerticularProduct(id);
        if (Objects.isNull(product)) {
			product = null;
		}
		return product;
	}

	
	
	public HashMap loginCheck(Product p) {
		Product product = dao.loginCheck(p);

		HashMap map = new HashMap();
		if (Objects.isNull(product)) {
			map.put("msg", "invalid user");

		} else {
			map.put("msg", "valid user");
		}
		map.put("user", product);

		return map;
	}

}
