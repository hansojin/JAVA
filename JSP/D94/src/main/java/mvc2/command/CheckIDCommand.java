package mvc2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc2.dao.MemberDAO;

public class CheckIDCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMDAO();
		String id = request.getParameter("id");
		HttpSession session = request.getSession(); 
		dao.idCheck(id, session);
	}

}
