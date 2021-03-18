package com.mphasis.pms.bos;


import java.util.List;
import java.util.Random;

import com.mphasis.pms.daos.ProductDao;
import com.mphasis.pms.daos.ProductDaoImpl;
import com.mphasis.pms.exceptions.BuisnessException;
import com.mphasis.pms.exceptions.RecordNotFoundException;
import com.mphasis.pms.pojos.Product;

public class ProductBoImpl implements ProductBo {

	ProductDao productDao;
	// Product[] products;
	// List<Product> products;

	public ProductBoImpl() {
		// products = new Product[4];
		productDao = new ProductDaoImpl();
		// products=new ArrayList<Product>();
	}

	@Override
	public void addProduct(Product p) throws BuisnessException {

		//if (p.getPid().matches("[P][0-9]{3}")) {// P000 --P999 [P][0-9]{3}
			if (p.getPname().matches("[A-Z][a-zA-Z0-9]{2,10}")) {
				if (p.getCost() > 0) {
					if (p.getQty() > 0 && p.getQty() <= 25) {
						Random random = new Random();

						// generate a random integer from 0 to 899, then add 100
						int x = random.nextInt(900) + 100;
						String pid="P"+x;
						p.setPid(pid);
						System.out.println(pid+"pid");
						 productDao.insertProduct(p);
//						if (i <= 0) {
//							throw new BuisnessException("Product id is already exists");
//						}
					} else {
						throw new BuisnessException("Quantity accepts 0 to 25");
					}
				} else {
					throw new BuisnessException("Cost accepts positive value");
				}
			} else {
				throw new BuisnessException(
						"Product Name starts with uppercase and follwed by lowercase 2 to 10 length");
			}
//		} else {
//			throw new BuisnessException("Invalid Product Id(Product Id should start with P and 3 digits)");
//		}

	}
	@Override
	public Product getProductByPid(String pid) {
		Product p=productDao.retiveProductById(pid);
		if(p == null) {
			throw new RecordNotFoundException("Requested Product is not aviable");
		}
		return p;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products=productDao.retriveProducts();
		if(products.isEmpty()) {
			throw new RecordNotFoundException("No Products available");
		}
		return products;
	}

	@Override
	public Product getProduct(int index) {
		List<Product> products=productDao.retriveProducts();
		return products.get(index);
	}

	@Override
	public void removeProduct(String pid) {
		int i=productDao.deleteProductById(pid);
		if(i<=0) {
			throw new RecordNotFoundException("Request Product not deleted");
		}
	}

	@Override
	public void updateProductCost(String pid, double cost) {
		productDao.updateProductCost(pid, cost);	
	}

}
