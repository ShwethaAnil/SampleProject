package com.mphasis.pms.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.pms.bos.GuserBo;
import com.mphasis.pms.bos.GuserBoImpl;
import com.mphasis.pms.pojos.Guser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GuserBo guserBo=new GuserBoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); 
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		try {
		if(guserBo.login(name, pass)) {
			//Session Code
			HttpSession session=request.getSession();
			session.setAttribute("sname", name);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("menu.html");
			rd.include(request, response);
			out.print("<h1>Welcome "+name+"</h1><br/>");
		}else {
			out.print("Invalid Credentials");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			//rd.forward(request, response);
		}
		}catch(Exception e) {
			out.print(e.getMessage());
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
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String gen=request.getParameter("gen");
		String[] langauages=request.getParameterValues("lan");
		String city=request.getParameter("city");
		
	
		Guser guser=new Guser();
		guser.setUsername(uname);
		guser.setPass(pass);
		try {
		guserBo.register(guser);
		out.print("User Details");
		out.print("<li>"+uname+"</li>"+"<li>"+gen+"</li>"+"<li>"+city+"</li>");
		for(String s:langauages) {
			out.print("<li>"+s+"</li>");
		}
		out.print("<br/>");
		RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);
		}catch(Exception e) {
			out.print(e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			rd.include(request, response);
		}
	}

}
