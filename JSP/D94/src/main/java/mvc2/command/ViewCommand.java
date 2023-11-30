package mvc2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.BulletinDAO;
import mvc2.dto.BulletinDTO;

public class ViewCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BulletinDAO dao = BulletinDAO.getBDAO();
		BulletinDTO dto = dao.viewContent(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("dto", dto);

	}

}
