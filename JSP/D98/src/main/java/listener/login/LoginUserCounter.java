package listener.login;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginUserCounter implements HttpSessionListener {

	private int userCount;
    public LoginUserCounter() {
    }

	// 세션이 생성되었을 때 호출
    public void sessionCreated(HttpSessionEvent se)  { 
    	++userCount;
        System.out.printf("생성된 SESSIONID %s \n",  se.getSession().getId());
        System.out.printf("로그인된 사용자 수 : %d \n", userCount);
    }

    // 세션이 제거되었을 때 호출
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	--userCount;
        System.out.printf("제거된 SESSIONID %s \n",  se.getSession().getId());
        System.out.printf("로그인된 사용자 수 : %d \n", userCount);
    }
	
}

/*
HttpSessionEvent 객체
구현된 리스너를 보면 각각의 메서드에서 HttpSessionEvent 객체가 매개변수로 넘어오는것을 볼 수 있는데,
이 객체는 제거 또는 생성된 HttpSession 객체를 리턴하는 getSession()메서드를 제공함 
위 예제에서는 이를통해 세션ID를 얻어오고 있음. 따라서 리스너에서 세션을 조작하는것도 가능함
*/
