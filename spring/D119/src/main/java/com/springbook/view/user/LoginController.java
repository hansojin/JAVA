package com.springbook.view.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserService;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;	
	
	@CrossOrigin("http://localhost:3000")
	@RequestMapping("/guam/memberCount.do")
	public ResponseEntity<Map<String, Integer>> memberCount(UserVO vo) {
	    Map<String, Integer> response = userService.memberCount(vo);
	    return ResponseEntity.ok(response);
	}
	
	
	
}