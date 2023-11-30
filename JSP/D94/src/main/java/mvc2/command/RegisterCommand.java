package mvc2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc2.dao.MemberDAO;
import mvc2.dto.MemberDTO;

public class RegisterCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMDAO();
		MemberDTO dto = new MemberDTO();
		dto.setName(request.getParameter("name"));
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setNickname(request.getParameter("nickname"));
		dto.setTel(request.getParameter("tel"));
		dto.setEmail(request.getParameter("email"));
		dto.setPostcode(request.getParameter("postcode"));
		dto.setRoadAddress(request.getParameter("roadAddress"));
		dto.setJibunAddress(request.getParameter("jibunAddress"));
		dto.setDetailAddress(request.getParameter("detailAddress"));
		dto.setExtraAddress(request.getParameter("extraAddress"));
		dto.setbYear(request.getParameter("bYear"));
		dto.setbMonth(request.getParameter("bMonth"));
		dto.setbDay(request.getParameter("bDay"));
		dto.setSex(request.getParameter("sex"));
		dao.memberRegister(dto);
	}

}
