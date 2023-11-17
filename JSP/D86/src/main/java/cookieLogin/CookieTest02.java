package cookieLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest02")
public class CookieTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTest02() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String remID = request.getParameter("remID");	
		
		if(remID != null && remID.equals("rememberID")){
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
		}
		else{
			Cookie[] cookies = request.getCookies();
			if(cookies !=null){
				System.out.println("쿠키삭제");
				for(int i=0;i<cookies.length;i++){
					String cookieName = cookies[i].getName();
					if(cookieName.equals("id")){
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
						break;
					}
				}				
			}
		}
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cookie Test</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(id +"님 " + "환영합니다. (" + pw + ")<br>");
		out.println("<a href='CookieTest01'>CookieTest01 페이지</a>");
		out.println("</body>");
		out.println("</html>");
	}
}