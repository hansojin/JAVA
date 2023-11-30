package mvc2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.BulletinDAO;
import mvc2.dto.BulletinDTO;

public class ReplyOKCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BulletinDAO dao = BulletinDAO.getBDAO();
		BulletinDTO dto = new BulletinDTO();
		dto.setId(request.getParameter("id"));
		dto.setTel(request.getParameter("tel"));
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dto.setGroupNum(Integer.parseInt(request.getParameter("groupNum")));
		dto.setIndentNum(Integer.parseInt(request.getParameter("indentNum")));
		dao.replyOK(dto);

	}

}
