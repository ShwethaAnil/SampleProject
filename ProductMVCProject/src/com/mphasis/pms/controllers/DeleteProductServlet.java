package com.mphasis.pms.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.pms.bos.ProductBo;
import com.mphasis.pms.bos.ProductBoImpl;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductBo productBo=new ProductBoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:8097/projectname/delete?pid=P123;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); 
		String pid=request.getParameter("pid");
		try {
		productBo.removeProduct(pid);
		out.print("deleted <br/>");
		
		}catch(Exception e) {
			out.print(e.getMessage());	
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("products");
		rd.include(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
