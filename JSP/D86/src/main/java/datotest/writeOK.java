package datotest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/writeOK")
public class writeOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public writeOK() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		int result = 0;
		dto.setTitle(request.getParameter("title"));
		dto.setName(request.getParameter("name"));
		dto.setPassword(request.getParameter("pw"));
		dto.setEmail(request.getParameter("email"));
		dto.setContents(request.getParameter("contents"));
		result = dao.insertBoardDAO(dto);
		if(result > 0) 
			response.sendRedirect("datotest/list.jsp");
		
	}

}
