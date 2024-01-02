package com.springbook.biz.board;

import java.sql.Date;
//import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
1. JSON 변환
 - @JsonIgnore는 자바 객체를 JSON으로 변환할 때, 특정 변수를 변환에서 제외시킨
2. XML 변환
 - @XmlAccessorType은 BoardVO 객체를 XML로 변환할 수 있다는 의미
 - XmlAccessType.FIELD : 이 객체가 가진 필드, 즉 변수들은 자동으로 자식 엘리먼트로 표현된다
 - @XmlAttribute : seq 변수 _ seq를 속성을 표현하라는 의미
 - @XmlTransient : XML 변환에서 제외
*/

@XmlAccessorType(XmlAccessType.FIELD)
public class BoardVO {
	@XmlAttribute
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	@XmlTransient
	private String searchCondition;
	@XmlTransient
	private String searchKeyword;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + 
				", regDate=" + regDate + ", cnt=" + cnt + "]";
	}
}

/* 
	XML 문서는 반드시 단 하나의 루트 엘리먼트를 가져야 한다. BoardVO는 하나의 게시글 정보를 저장하려고 사용하는 객체이다. 
	하지만 우리는 여러 게시글 목록을 XML로 표현해야 하므로 BoardVO 객체 여러 개를 포함하면서 루트엘리먼트로 사용할 또 다른 자바 클래스가 필요하다. 
	루트 엘리먼트로 사용할 BoardListVO 클래스를 추가로 작성해야한다.
*/