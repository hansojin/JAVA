package com.springbook.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="boardList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	@XmlElement(name="board")
	private List<BoardVO> boardList;
	
	public BoardListVO() {
	}
	
	public List<BoardVO> getBoardList(){
		return boardList;
	}
	
	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
}

/*
	@XmlRootElement(name="boardList") 
	: 이 객체가 루트 엘리먼트에 해당하는 객체이며, 루트 엘리먼트 이름을 boardList로 절정하겠다
	
	@XmlElement(name = "board")
	: boardList 변수 위에 해당 설정을 하지 않으면,  변수 이름인 boardList가 엘리먼트 이름으로 사용됨
	
 */