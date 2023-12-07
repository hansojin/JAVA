package ajax.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajax.dao.UserDAO;
import ajax.dto.UserDTO;

public class UserRegisterCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = UserDAO.getUserDAO();
		UserDTO dto = new UserDTO();
		try {
			dto.setUserName(request.getParameter("userName"));
			dto.setUserAge(Integer.parseInt(request.getParameter("userAge")));
			dto.setUserGender(request.getParameter("userGender"));
			dto.setUserEmail(request.getParameter("userEmail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("result", userDAO.register(dto));

	}

}
