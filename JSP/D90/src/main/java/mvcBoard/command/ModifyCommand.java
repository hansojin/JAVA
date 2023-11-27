package mvcBoard.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcBoard.dao.BoardDAO;
import mvcBoard.dto.BoardDTO;

public class ModifyCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getBoardDAO();
		BoardDTO dto = new BoardDTO();
		int no=Integer.parseInt(request.getParameter("no"));
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dao.modifyPost(dto,no);

	}

}
