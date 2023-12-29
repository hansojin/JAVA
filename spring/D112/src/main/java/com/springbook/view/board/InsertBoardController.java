package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
}

/*
	Command 객체는 Controller 메소드 매개변수로 받은 VO(Value Object) 객체라고 보면 된다. 
	InsertBoardController 클래스의 insertBoard() 메소드를 Command 객체를 이용하여 구현한다.

	insertBoard() 메소드의 매개변수로 사용자가 입력한 값을 매핑할 BoardVO 클래스를 선언하면, 
	스프링 컨테이너가 insertBoard() 메소드를 실행할 때 Command 객체를 생성하여 넘겨준다. 
	그리고 이때 사용자가 입력한 값들을 Command 객체에 세팅까지 해서 넘겨준다. 
	결과적으로 사용자 입력 정보 추출과 VO 객체 생성, 그리고 값 설정을 모두 컨테이너가 자동으로 처리하는 것이다.

	여기서 중요한 것은 Form 태그 안의 파라미터 이름과 Command 객체의 Setter 메소드 이름이 반드시 일치해야 한다. 
	즉, 각 파라미터 이름에 해당하는 setTitle(), setWriter(), setContent() 메소드가 있어야 Setter 인젝션에 의해 자동으로 사용자 입력값이 저장된다.
	
	---
	
	우선 글 등록 처리가 성공한 후에는 글 목록을 출력해야 하기 때문에,
	GetBoardListController를 실행시키기 위해 리턴타입을 String으로 수정하고 "getBoardList.do"를 리턴한다. 
	그리고 사용자 입력값을 Command 객체로 받기 위해 BoardVO 클래스를 매개변수로 선언했고, DB 연동 처리를 위해 BoardDAO도 매개변수로 선언했다. 
	DAO 객체 역시 Command 객체와 마찬가지로 매개변수로 선언하면 스프링 컨테이너가 해당 객체를 생성하여 전달해준다.
	
	리다이렉트로 넘기기
	Controller 메소드가 실행되고 View 경로를 리턴하면 기본이 포워딩 방식이므로 글등록 후에 목록 화면이 출력되도 브라우저의 URL은 변경되지 않는다.
	http://localhost:8080/biz/insertBoard.do
	따라서 포워딩이 아니라 리다이렉트를 원할 때는 "redirect:"라는 접두사를 붙여야 한다.
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	위 소스는 글 등록 처리 후에 "getUserList.do"로 리다이렉트 되어, 최종 URL은 다음처럼 변경된다.
	http://localhost:8080/biz/getBoardList.do
	
*/