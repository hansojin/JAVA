package mvcBoard.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcBoard.dao.BoardDAO;
import mvcBoard.dto.BoardDTO;

public class ContentCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getBoardDAO();
		BoardDTO dto = dao.contentView(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("dto", dto);

	}

}
