package cookieLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest01")
public class CookieTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTest01() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		
		boolean flag = false;
		String id = null;
		if(cookies != null){
			for(int i=0;i<cookies.length;i++){
				String cookieName = cookies[i].getName();
				if(cookieName.equals("id")){
					flag = true;
					id = cookies[i].getValue();
					break;
				}
			}
		}
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cookie Test</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='CookieTest02'>");		
		out.println("<table>");	
		out.println("<tr><td>아이디</td><td><input type='text' name='id'");
		if(flag)
			out.println("value='" + id + "'");
		out.println("></td></tr>");
		out.println("<tr><td>비밀번호</td><td><input type='text' name='pw'></td></tr>");
		out.println("<tr><td colspan='2'><input type='checkbox' name='remID'");
		if(flag)
			out.println("checked");
		out.println("value='rememberID'> 아이디 기억하기</td></tr>");
		out.println("<tr><td colspan='2'><input type='submit' value='로그인'></td></tr>");
		out.println("</table>");		
		out.println("</form>");		
		out.println("</body>");
		out.println("</html>");
	}
}