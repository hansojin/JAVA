package mvc2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.BulletinDAO;
import mvc2.dao.MemberDAO;
import mvc2.dto.BulletinDTO;
import mvc2.dto.MemberDTO;

public class ReplyCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BulletinDAO dao = BulletinDAO.getBDAO();
		MemberDAO daoM = MemberDAO.getMDAO();
		BulletinDTO dto = dao.replyView(Integer.parseInt(request.getParameter("no")));
		MemberDTO dtoM = daoM.selectInfo(request.getParameter("id"));
		request.setAttribute("dto", dto);
		request.setAttribute("dtoM", dtoM);

	}

}
