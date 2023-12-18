package annotation2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	@Resource(name="apple")
	private Speaker speaker;
	
//	@Resource 선언만 하면 클래스 이름이 'apple'인 빈 스프링 객체가 자동으로 생성됨
//	비슷한 annotation으로는 @Autowired, @Inject이 있음
	
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

