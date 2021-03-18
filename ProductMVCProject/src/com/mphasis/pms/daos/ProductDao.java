package com.mphasis.pms.daos;

import java.util.List;

import com.mphasis.pms.pojos.Product;

public interface ProductDao {
	//CRUD
	
	
	public int insertProduct(Product p);
	public int updateProductCost(String pid,double cost);
	public int updateProductRatings(String pid, double ratings);
	public int updateProductQuantity(String pid,int qty);
	public int deleteProductById(String pid);
	public	List<Product> retriveProducts();
	public	Product retiveProductById(String pid);
}
