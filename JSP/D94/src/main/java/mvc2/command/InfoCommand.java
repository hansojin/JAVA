package mvc2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.MemberDAO;
import mvc2.dto.MemberDTO;

public class InfoCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMDAO();
		MemberDTO dto = new MemberDTO();
		String id = request.getParameter("id");
		dto = dao.selectInfo(id);
		request.setAttribute("dto", dto);
	}

}
