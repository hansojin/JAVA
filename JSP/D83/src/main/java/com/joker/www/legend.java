package com.joker.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/legendary")
public class legend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public legend() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>HELLO SERVLET</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<p>hello doGET</p>");
		out.print("</body>");
		out.print("</html>");
	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>HELLO SERVLET</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<p>hello SERVICE</p>");
		out.print("</body>");
		out.print("</html>");
	}
	
	//	우선순위는 service가 더 높다 ! => 출력 : hello SERVICE

}
