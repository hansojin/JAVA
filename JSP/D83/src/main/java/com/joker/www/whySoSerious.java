package com.joker.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//해당 폴더명/아래 매핑명 으로 주소가 연결됨 :  D83/whySoSerious
@WebServlet("/whySoSerious")
public class whySoSerious extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public whySoSerious() {
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
		out.print("<p>hello</p>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
