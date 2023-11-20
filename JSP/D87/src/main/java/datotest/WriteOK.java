package datotest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WriteOK")
public class WriteOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteOK() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		
		dto.setTitle(request.getParameter("title"));
		dto.setName(request.getParameter("name"));
		dto.setPassword(request.getParameter("pw"));
		dto.setEmail(request.getParameter("email"));
		dto.setContents(request.getParameter("contents"));
		
		result = dao.insertDAO(dto);
		if (result>0)
			response.sendRedirect("datotest/list.jsp");
	}

}
