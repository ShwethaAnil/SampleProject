package com.mphasis.pms.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet(urlPatterns = { "/profile" }, 
initParams = { 
		@WebInitParam(name = "role", value = "admin")
} )
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); 
//		Cookie ck[]=request.getCookies();
//		for(Cookie c:ck) {
//			if(c.getName().equalsIgnoreCase("ckname")) {
//				out.print("Logged in as "+c.getValue());
//			}
//		}
		
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http1.1
		try {
		HttpSession session=request.getSession(false);
		
		RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);	
		out.print("<h1>Logged in as "+session.getAttribute("sname")+"</h1><br/>");
		out.print("<br/>Profile Details");
		}catch(Exception e) {
			out.print("Please Login again");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);	
		}
		
		
//		//Servlet context
//		ServletContext context=getServletContext();
//		String cParam=context.getInitParameter("driver");
//		out.print(" context param value "+cParam);
//		//Servlet Config
//		ServletConfig config=getServletConfig();
//		String configParam=config.getInitParameter("role");
//		out.print(" config param value "+configParam);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
