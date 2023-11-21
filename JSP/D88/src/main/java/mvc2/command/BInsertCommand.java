package mvc2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.BoardDAO;
import mvc2.dto.BoardDTO;

public class BInsertCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		request.setCharacterEncoding("UTF-8");

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();

		dto.setTitle(request.getParameter("title"));
		dto.setName(request.getParameter("name"));
		dto.setContents(request.getParameter("contents"));

		result = dao.insertDAO(dto);
		if (result>0)
			request.getRequestDispatcher("mvc2/list.jsp").forward(request, response);
		

	}

}
