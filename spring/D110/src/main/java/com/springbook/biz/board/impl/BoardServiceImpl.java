package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAOSpring boardDAO;
//	private BoardDAO boardDAO;

	public BoardServiceImpl() {
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
//		예외 강제 발생 -> transaction으로 롤백(Rollback) 처리 -> 위에 정상 처리된 insert도 취소됨
//		int num = 0;
//		if(num==0) throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
}