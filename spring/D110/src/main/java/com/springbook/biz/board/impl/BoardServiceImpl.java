package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAOSpring boardDAO;

	@Override
	public void insertBoard(BoardVO vo) {
//		boardDAO.insertBoard(vo);
//		int num = 0;
//		if(num==0) throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		boardDAO.insertBoard(vo);
//		트랜잭션은 메소드 단위로 관리 되므로 첫번째 입력이 성공했음에도 불구하고
//		두번째 입력 전 예외가 발생했기 때문에 rollback 모든 작업 결과가 rollback 처리됨
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
