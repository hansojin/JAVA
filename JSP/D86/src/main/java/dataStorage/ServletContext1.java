package dataStorage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletContext1")
public class ServletContext1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletContext1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intro = "Welcome to SERVER";
		
		ServletContext context = this.getServletContext();
		context.setAttribute("intro", intro);
		// 이렇게 저장된 데이터는 이 서버에 접속된 사용자 누구나 볼수 있고
		// 서버가 종료 되어야 비로소 사라짐
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.println("ServletContext 데이터 생성 완료!");
		out.println("</body></html>");
	}

}
