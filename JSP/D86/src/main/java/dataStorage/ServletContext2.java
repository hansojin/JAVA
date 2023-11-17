package dataStorage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContext2")
public class ServletContext2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletContext2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String intro = (String)context.getAttribute("intro");
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.println("SERVER : " + intro);
		out.println("</body></html>");
	}

}
