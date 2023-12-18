package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	@Autowired
	@Qualifier("apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 객체생성");
	}
	public void powerOn(){
		System.out.println("LgTV --- 전원 켠다.");
	}
	public void powerOff(){
		System.out.println("LgTV --- 전원 끈다.");
	}
	public void volumeUp(){
		speaker.volumeUp();
	}
	public void volumeDown(){
		speaker.volumeDown();
	}
}

/*
스프링 설정 파일에서 빈을 생성하든, @Component를 쓰던, 두 설정 모두 해당 클래스에 "기본 생성자가 있어야만" 컨테어니가 객체를 생성할 수 있다. 
이렇게 설정했다면 클래스의 객체가 메모리에 생성되는 것은 문제 없다. 그러나 클라이언트 프로그램에서 LgTV 객체를 요청할 수는 없다. 
클라이언트가 생성한 객체를 요청하려면, 요청할 때 사용할 아이디나 이름이 반드시 설정되어 있어야 한다.

XML 설정
<bean id="tv" class="polymorphism.LgTV"></bean>

Annotation 설정
@Component("tv")
public class LgTV implements TV{
	public LgTV(){
		System.out.println("===> LgTV 객체 생성");
	}
}

참고 : id나 name 속성 미지정 시 이름규칙
스프링 컨테이너가 클래스 객체를 생성할 때, id나 name 속성을 지정하지 않았다면, 컨테이너가 자동으로 이름을 설정해준다. 
이때 이름 규칙은 클래스 이름의 첫글자를 소문자로 변경하기만 하면 된다. 따라서 id나 name 속성이 설정되지 않은 경우, 
LgTV 객체를 요청하려면 lgTV라는 이름을 사용하면 된다.

---

@Autowired : 알아서 의존 객체(Bean)을 찾아서 주입
@Qualifier : 의존 객체가 2개 이상이면 컨테이너는 어떤 객체를 할당할지 판단할 수 없어서 에러가 발생하므로, 하나의 객체를 주입


*/