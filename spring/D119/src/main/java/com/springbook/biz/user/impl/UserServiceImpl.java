package com.springbook.biz.user.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAOMybatis userDAO;

	@Override
	public Map<String, Integer> memberCount(UserVO vo) {
	    int num = userDAO.memberCount(vo);
	    System.out.println("회원수 " + num);

	    Map<String, Integer> response = new HashMap<>();
	    response.put("count", num);

	    return response;
	}

	
	
}