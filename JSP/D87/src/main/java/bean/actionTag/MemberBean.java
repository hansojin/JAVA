package bean.actionTag;

import java.io.Serializable;

public class MemberBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String major;
	
	public MemberBean() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}

/*
 
자바빈즈는 데이터 표현을 목적으로 하는 자바 클래스이므로 기존의 자바 클래스를 작성하는 방법과 동일하게 작성한다. 

자바빈즈는 데이터를 담는 멤버 변수인 프로퍼티(property)와 데이터를 가져오거나 저장하는 메소드로 구성된다. 

자바빈즈를 작성할 때는 다음 규칙을 따라야 한다.
1. 자바 클래스는 java.io.Serializable 인터페이스를 구현해야 한다.
	: java.io.Serializable 인터페이스는 생략 가능하나 자바빈즈 규약에 명시된 내용으로 자바빈즈에 저장된 프로퍼티를 포함한 채로 파일 시스템에 저장되거나 
	  네트워크로 전송될 수 있도록 객체 직렬화를 제공해야 하므로 implement 해야 한다.
2. 인수가 없는 기본 생성자가 있어야 한다.
3. 모든 멤버 변수인 프로퍼티는 private 접근 지정자로 설정해야 한다.
4. 모든 멤버 변수인 프로퍼티는 getter/setter() 메소드가 존재해야 한다. 

참고 > 자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 
바이트(byte) 형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)을 아울러서 말함

*/