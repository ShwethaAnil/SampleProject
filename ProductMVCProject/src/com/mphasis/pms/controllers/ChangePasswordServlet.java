package com.mphasis.pms.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.pms.bos.GuserBo;
import com.mphasis.pms.bos.GuserBoImpl;
import com.mphasis.pms.exceptions.RecordNotFoundException;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/change")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      GuserBo guserBo=new GuserBoImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPass=request.getParameter("opass");
		String newPass=request.getParameter("npass");
		HttpSession session=request.getSession(false);
		String name=session.getAttribute("sname").toString();
		ServletContext context=getServletContext();
		try {
		guserBo.changePassword(oldPass, newPass, name);
		System.out.println(oldPass+" "+newPass);
		context.setAttribute("message",  "password Changed");
		
		System.out.println("Change the password");
		}catch (RecordNotFoundException e) {
			context.setAttribute("message", e.getMessage());
		}
		RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
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
