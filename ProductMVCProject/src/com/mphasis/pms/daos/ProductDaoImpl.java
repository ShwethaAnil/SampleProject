package com.mphasis.pms.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.pms.pojos.Product;
import com.mphasis.pms.util.DbUtil;

public class ProductDaoImpl implements ProductDao {
	Connection con = null;

	public ProductDaoImpl() {
		con = DbUtil.createConnection();
//		try {
//		Statement st=con.createStatement();
//		st.execute("drop table product");
//		st.execute("create table product\r\n" + 
//				"    (pid varchar(5)primary key,\r\n" + 
//				"    pname varchar(20),\r\n" + 
//				"    cost number(10,2),\r\n" + 
//				"  qty number,\r\n" + 
//				"  catagory varchar(20),\r\n" + 
//				" ratings number)");
//		
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		
	}

	@Override
	public int insertProduct(Product p) {
		int i = 0;
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("insert into product values(?,?,?,?,?,?)");

			pst.setString(1, p.getPid());
			pst.setString(2, p.getPname());
			pst.setDouble(3, p.getCost());
			pst.setInt(4, p.getQty());
			pst.setString(5, p.getCatagory());
			pst.setDouble(6, p.getRatings());

			i = pst.executeUpdate();
//execute-boolean, executeUpdate-int, executeQuery-ResultSet
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateProductCost(String pid, double cost) {
		int i=0;
		try {
		PreparedStatement pst=con.prepareStatement("update product set cost=? where pid=?");
		pst.setDouble(1, cost);
		pst.setString(2, pid);
		
		i=pst.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateProductRatings(String pid, double ratings) {
		int i=0;
		try {
		PreparedStatement pst=con.prepareStatement("update product set ratings=? where pid=?");
		pst.setDouble(1, ratings);
		pst.setString(2, pid);
		
		i=pst.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
		}

	@Override
	public int updateProductQuantity(String pid, int qty) {
		int i=0;
		try {
		PreparedStatement pst=con.prepareStatement("update product set qty=? where pid=?");
		pst.setInt(1, qty);
		pst.setString(2, pid);
		
		i=pst.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteProductById(String pid) {
		int i=0;
		try {
			PreparedStatement pst=con.prepareStatement("delete from product where pid=?");
			pst.setString(1, pid);
			
			i=pst.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Product> retriveProducts() {
		List<Product> products=new ArrayList<Product>();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from product");
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getString(1)); //pid
				p.setPname(rs.getString(2)); //pname
				p.setCost(rs.getDouble(3)); //cost
				p.setQty(rs.getInt(4)); //qty
				p.setCatagory(rs.getString(5));//catagory
				p.setRatings(rs.getDouble(6)); //ratings
				products.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product retiveProductById(String pid) {
		Product p=new Product();
		try {
			PreparedStatement pst=con.prepareStatement("select * from product where pid=?");
			pst.setString(1, pid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				p.setPid(rs.getString(1)); //pid
				p.setPname(rs.getString(2)); //pname
				p.setCost(rs.getDouble(3)); //cost
				p.setQty(rs.getInt(4)); //qty
				p.setCatagory(rs.getString(5));//catagory
				p.setRatings(rs.getDouble(6)); //rat
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
