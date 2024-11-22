package com.tka.NimapMachineTest.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.NimapMachineTest.Service.MainService;
import com.tka.NimapMachineTest.entity.Category;
import com.tka.NimapMachineTest.entity.Product;

    @CrossOrigin
	@RestController
	@RequestMapping("api")

	public class MainController {
		@Autowired
		MainService service;
		
		@PostMapping("addcategory")
		public String addCategory(@RequestBody Category c) {
	     String msg= service.addCategory(c);
	     return msg;
		}
		
	@PutMapping("updatecategory/{id}")
	public String updateCategory(@RequestBody Category c,@PathVariable int id) {
		String str=service.updateCategory(c,id);
		
		 return str;
		 }

	@DeleteMapping("deletecategory/{id}")
	public String deleteCategory(@PathVariable int cid) {
		String str=service.deleteCategory(cid);	
		 return str;
	}
	@GetMapping("getall")
	public List<Category>getAllRecord(@RequestParam int page ,@RequestParam(defaultValue = "3") int page_size){
		List<Category>list=service.getAllRecord(page,page_size);
		return list;
	}

	@GetMapping("getcategorybyid/{cid}")
	public Category getparticularCategoryById(@PathVariable int cid) {
		Category category=service.getparticularCategoryById(cid);
		return category;
	}

	@PostMapping("addproduct")
	public String addProduct(@RequestBody Product product) {
	String str=service.addProduct(product);
	return str;
	}


	@PutMapping("updateproduct/{id}")
	public String updateProduct(@RequestBody Product product,@PathVariable int id) {
	String str=service.updateProduct(product, id);		
	 return str;
	 }

	@DeleteMapping("deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		String str=service.deleteProduct(id);	
		 return str;
	}

	@GetMapping("getallproduct")
	public List<Product>getAllProduct(@RequestParam int page,@RequestParam(defaultValue = "3")int page_size){
		List<Product>list=service.getAllProduct(page,page_size);
		return list;
	}

	@GetMapping("getperticularproduct/{id}")
	public Product getPerticularProduct(@PathVariable int id) {
		Product product=service.getPerticularProduct(id);
		return product;
	}
	@PostMapping("login")
	public HashMap loginCheck(@RequestBody Product p) {
		HashMap map=service.loginCheck(p);
		return map;
	}
	}
	


