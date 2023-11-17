package dataStorage;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SesArea1")
public class SesArea1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SesArea1() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("one", "JH");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("two", "TM");
		
		Calendar three = Calendar.getInstance();
		session.setAttribute("three", three);
		
		ServletContext context=this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/SesArea2");
		dispatcher.forward(request, response);
		
		
	}



}
