package cookieLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookie = request.getCookies();
		String cookieID=null, cookieRem=null;
		if(cookie!=null) {
			for(int i=0;i<cookie.length;i++) {
				String str=cookie[i].getName();
				if (str.equals("id")) {
					cookieID = cookie[i].getValue();
				}
				else if(str.equals("rem"))
					cookieRem = cookie[i].getValue();
			}
		}
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>LOGIN SERVLET</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='WelcomePage'>");
		out.println("<label for='id'>I D </label>");
		out.println("<input type='text' id='id' name='id' value='" + (cookieID != null ? cookieID : "") + "' required><br>");
		out.println("<label for='pw'>PW </label>");
		out.println("<input type='password' id='pw' name='pw' required><br>");
		out.println("<label for='rem'>");
		out.println("<input type='checkbox' id='rem' name='rem' " + (cookieRem != null ? "checked='checked'" : "") + ">Remember ID<br>");
		out.println("<input type='submit' value='LOGIN' style='background-color: white;width:200px'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}


	

}
