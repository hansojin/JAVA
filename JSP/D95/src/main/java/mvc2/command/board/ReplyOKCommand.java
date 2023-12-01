package mvc2.command.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.command.Command;
import mvc2.dao.BoardDAO;
import mvc2.dto.BoardDTO;

public class ReplyOKCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getBoardDAO();
		BoardDTO dto = new BoardDTO();
		dto.setId(request.getParameter("id"));
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setGroupNum(Integer.parseInt(request.getParameter("groupNum")));
		dto.setStepNum(Integer.parseInt(request.getParameter("stepNum")));
		dto.setIndentNum(Integer.parseInt(request.getParameter("indentNum")));
		dao.replyOKDAO(dto);
	}
}