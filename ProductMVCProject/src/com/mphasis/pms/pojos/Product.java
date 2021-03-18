package com.mphasis.pms.pojos;

public class Product {
	private String pid;
	private String pname;
	private double cost;
	private int qty;
	private String catagory;
	private double ratings;
	// no arg constructor
	//parameterized constructor
	//constructor
	//getters setters and toString
	public Product() {
		
	}
	
	public Product(String pid, String pname, double cost, int qty, String catagory) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.qty = qty;
		this.catagory = catagory;
	}
	
	
	public Product(String pid, String pname, double cost, int qty, String catagory, double ratings) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.qty = qty;
		this.catagory = catagory;
		this.ratings = ratings;
	}



	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", qty=" + qty + ", catagory=" + catagory
				+ ", ratings=" + ratings + "]";
	}



	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public double getCost() {
		return cost;
	}



	public void setCost(double cost) {
		this.cost = cost;
	}



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public String getCatagory() {
		return catagory;
	}



	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}



	public double getRatings() {
		return ratings;
	}



	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
	

}
