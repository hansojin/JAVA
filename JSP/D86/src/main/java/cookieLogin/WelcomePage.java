package cookieLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomePage")
public class WelcomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WelcomePage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id= request.getParameter("id");
		String rem= request.getParameter("rem");
		out.println("WELCOME " + id);
		if (rem!=null) {
			Cookie cookieID = new Cookie("id", id);
			Cookie cookieREM = new Cookie("rem", rem);
			cookieID.setMaxAge(60*60*60);
			cookieREM.setMaxAge(60*60*60);
			response.addCookie(cookieID);
			response.addCookie(cookieREM);
		}else {
			Cookie[] cookies = request.getCookies();
			for(int i=0;i<cookies.length;i++) {
				String cookieProperty = cookies[i].getName();
				if(cookieProperty.equals("id")){
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					break;
				}
				else if (cookieProperty.equals("rem")){
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					break;
				}
			}
		}
		out.println("<br><a href ='LoginPage'>toLoginPage</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
