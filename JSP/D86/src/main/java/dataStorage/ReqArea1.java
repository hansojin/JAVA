package dataStorage;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReqArea1")
public class ReqArea1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ReqArea1() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data1 = new String("hello");
		Vector<String> data2 = new Vector<String>();
		data2.add("world");
		data2.add("!");
		
		//request scope에 데이터 저장
		request.setAttribute("data1", data1);
		request.setAttribute("data2", data2);
		
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/ReqArea2?data3=wanna&data4=gohome");
		dispatcher.forward(request, response);
		//forward 이동은 sendRedirect와는 다르게 저장된 모든 값을 가지고 이동
		
		
	}

}
