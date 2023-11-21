package mvc2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.BoardDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result;
		String no = request.getParameter("no");
		BoardDAO dao = new BoardDAO();

		result = dao.deleteDAO(Integer.parseInt(no));
		if (result>0)
			request.getRequestDispatcher("mvc2/list.jsp").forward(request, response);
	}

}
