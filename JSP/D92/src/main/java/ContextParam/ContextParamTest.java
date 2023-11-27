package ContextParam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextParamTest")
public class ContextParamTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextParamTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String name = context.getInitParameter("Name");
		String num = context.getInitParameter("Num");
		String email = context.getInitParameter("Email");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>" + name + "</h2>");
		out.println("<h2>" + num + "</h2>");
		out.println("<h2>" + email + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
