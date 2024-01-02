package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController{
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO  vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO,HttpSession session) {
		System.out.println("로그인 처리");
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else 
			return "login.jsp";
	}
}

/*
1. LoginController에 "/login.do"로 get 방식으로 요청이 들어오면 
UserVO에 아이디(test), 비밀번호(test123)을 셋해서 login.jsp로 이동해서 아이디와 비밀번호를 위에 것으로 입력되어있게 하는 loginView 메소드를 만든다.

2. LoginController에 "/login.do"로 post 방식으로 요청이 들어오면
아이디와 비밀번호가 db에 있는 것과 일치하면 리스트항목으로 이동하게 하고, 일치하지 않으면 "login.jsp"로 이동하게 하자.
*/