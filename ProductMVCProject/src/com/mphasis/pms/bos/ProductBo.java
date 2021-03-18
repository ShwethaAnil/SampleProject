package com.mphasis.pms.bos;

import java.util.List;

import com.mphasis.pms.exceptions.BuisnessException;
import com.mphasis.pms.pojos.Product;

public interface ProductBo {

	public void addProduct(Product p)throws BuisnessException;
	public List<Product> getAllProducts();
	public Product getProduct(int index);
	public Product getProductByPid(String pid);
	public void removeProduct(String pid);
	public void updateProductCost(String pid,double cost);
	
//public	Product[] getProductByCategory(String category);
	
}
