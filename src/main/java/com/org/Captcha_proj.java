package com.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/form")
public class Captcha_proj  extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("name");
		
		Random random=new Random();
		
		String captcha = ""+random.nextInt(9) +random.nextInt(9) +random.nextInt(9);
		
//		ServletContext context = getServletContext();
//		
//		context.setAttribute("genCaptcha" , captcha);
		
		HttpSession session=req.getSession();
		session.setAttribute("genCaptcha", captcha);
		
		PrintWriter out= resp.getWriter();
		
		resp.setContentType("text/html");
		
		out.println("<h3> Hello"+name+",plz enter the capcha :"+captcha+"</h3>");
		
		out.println("<form action='Verify_captcha' method='post'>"
		               +"<input type='text' name='captcha'><br><br>"
		               + "<input type='submit'>"
				);
		
		
	}
}
