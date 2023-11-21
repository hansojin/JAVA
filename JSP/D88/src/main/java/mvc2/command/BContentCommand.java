package mvc2.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.BoardDAO;
import mvc2.dto.BoardDTO;

public class BContentCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String no = request.getParameter("no");
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.selectOne(Integer.parseInt(no));
		
		BoardDTO dto = list.get(0);
		request.setAttribute("boardDTO", dto);
		request.getRequestDispatcher("mvc2/content_view.jsp").forward(request, response);

	}

}
