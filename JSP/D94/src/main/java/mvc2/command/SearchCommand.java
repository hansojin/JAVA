package mvc2.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.BulletinDAO;
import mvc2.dto.BulletinDTO;

public class SearchCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BulletinDAO dao = BulletinDAO.getBDAO();
		String sBox = request.getParameter("searchBox");
		String sBar = request.getParameter("searchBar");
		ArrayList<BulletinDTO> list = dao.selectPost(sBox,sBar);
		request.setAttribute("slist", list);
		request.setAttribute("searchFlag", "true");
		

	}

}
