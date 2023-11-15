package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>LOGIN SERVLET</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='LoginCheck'>");
		String id = (String)session.getAttribute("id");
		if (id==null) {
			out.println("ID : <input type='text' name='id'>");
			out.println("PW : <input type='password' name='password'>");
			out.println("<input type='submit' value='LOGIN' style='background-color:white'>");
		}else {
			out.println("hello " + id+ "<br>");
			out.println("<a href= 'Logout'>LOGOUT</a>");
		}
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
