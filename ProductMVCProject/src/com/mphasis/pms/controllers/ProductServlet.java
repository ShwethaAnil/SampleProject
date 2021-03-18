package com.mphasis.pms.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.pms.bos.ProductBo;
import com.mphasis.pms.bos.ProductBoImpl;
import com.mphasis.pms.exceptions.BuisnessException;
import com.mphasis.pms.pojos.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductBo productBo=new ProductBoImpl();
       int i=200;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http1.1
		response.setHeader("Pragma", "no-cache"); //Http 1.0
		response.setHeader("Expires", "0");//Proxies
		try {
			List<Product> products=productBo.getAllProducts();
			ServletContext context=getServletContext();
			context.setAttribute("products", products);
			RequestDispatcher rd=request.getRequestDispatcher("adminproducts.jsp");
			rd.forward(request, response);
		

		}catch(Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		Product p=new Product();
		p.setPname(request.getParameter("pname"));
		p.setCost(Double.parseDouble(request.getParameter("cost")));
		p.setQty(Integer.parseInt(request.getParameter("qty")));
		p.setRatings(0);
		p.setCatagory(request.getParameter("category"));
		try {
			productBo.addProduct(p);
			out.print("product added");
			RequestDispatcher rd=request.getRequestDispatcher("adminproducts.jsp");
			rd.include(request, response);
			
		} catch (BuisnessException e) {
			out.print(e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("addproduct.jsp");
			rd.include(request, response);
		}
	}

}
