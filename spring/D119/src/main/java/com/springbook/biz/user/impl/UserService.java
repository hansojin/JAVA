package com.springbook.biz.user.impl;

import java.util.Map;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;

public interface UserService {

	Map<String, Integer> memberCount(UserVO vo);
}