package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/login.do")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			if(user != null) 
				response.sendRedirect("getBoardList.do");
			else 
				response.sendRedirect("login.jsp");			
		} else if(path.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");			
		} else if(path.equals("/insertBoard.do")) {
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			response.sendRedirect("getBoardList.do");			
		} else if(path.equals("/updateBoard.do")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			response.sendRedirect("getBoardList.do");			
		} else if(path.equals("/deleteBoard.do")) {
	    	String seq = request.getParameter("seq");
	    	BoardVO vo = new BoardVO();
	    	vo.setSeq(Integer.parseInt(seq));
	    	BoardDAO boardDAO = new BoardDAO();
	    	boardDAO.deleteBoard(vo);
	    	response.sendRedirect("getBoardList.do");			
		} else if(path.equals("/getBoard.do")) {
			String seq = request.getParameter("seq");
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		} else if(path.equals("/getBoardList.do")) {
	    	BoardVO vo = new BoardVO();
	    	BoardDAO boardDAO = new BoardDAO();
	    	List<BoardVO> boardList = boardDAO.getBoardList(vo);		
	    	HttpSession session = request.getSession();
	    	session.setAttribute("boardList", boardList);
	    	response.sendRedirect("getBoardList.jsp");
		}
	}

}
