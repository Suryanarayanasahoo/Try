package com.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/Verify_captcha")

public class Verify_captcha extends HttpServlet

{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String captcha =req.getParameter("captcha");
	
//	ServletContext context = getServletContext();
//	String genCaptcha = (String)context.getAttribute("genCaptcha");
	

	HttpSession sesion = req.getSession();
	String genCaptcha = (String) sesion.getAttribute("genCaptcha");
	
	PrintWriter out= res.getWriter();
	
	res.setContentType("text/html");
	
	if (captcha.equals(genCaptcha))
	{
		out.println("<h1> you are a human </h1>");
	}
	else {
		out.println("<h1> you are not a human </h1>");
	}
}
}
