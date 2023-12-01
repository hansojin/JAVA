package mvc2.command.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc2.command.Command;
import mvc2.dao.MemberDAO;
import mvc2.dto.MemberDTO;

public class MemberModifyOKCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getMemberDAO();
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();
		
		dto.setName(request.getParameter("name"));
		dto.setId(request.getParameter("id"));
		dto.setNickname(request.getParameter("nickname"));
		dto.setPw(request.getParameter("pw"));
		dto.setEmail(request.getParameter("email"));
		dto.setPostcode(request.getParameter("postcode"));
		dto.setRoadAddress(request.getParameter("roadAddress"));
		dto.setJibunAddress(request.getParameter("jibunAddress"));
		dto.setDetailAddress(request.getParameter("detailAddress"));
		dto.setExtraAddress(request.getParameter("extraAddress"));
		dto.setBirthYear( Integer.parseInt(request.getParameter("birthYear")) );
		dto.setBirthMonth( Integer.parseInt(request.getParameter("birthMonth")) );
		dto.setBirthDate( Integer.parseInt(request.getParameter("birthDate")) );
		dto.setCellphone(request.getParameter("cellphone"));
		dto.setGender(request.getParameter("gender"));
		dao.memberModifyDAO(dto);
		
		session.setAttribute("userInfo", dto);
	}
}