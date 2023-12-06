package shine.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shine.dao.MemberDAO;

public class IDCheckCommand implements Command {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMemberDAO();
		int result = dao.checkId(request.getParameter("id"));
		request.setAttribute("result", result);
	}

}
