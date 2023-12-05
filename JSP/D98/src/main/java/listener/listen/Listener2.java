package listener.listen;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class Listener2 implements HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener, ServletRequestAttributeListener {

    public Listener2() {
    }
    
	// ServletRequest 객체가 초기화 될 때 발생    
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("ServletRequest 객체가 초기화 되었습니다.");
		System.out.println("request = " + sre.getServletRequest());
    }
    
	// ServletRequest 객체가 소멸 될 때 발생
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("ServletRequest 객체가 소멸 되었습니다.");
		System.out.println("request = " + sre.getServletRequest());
    }

	// ServletRequest 영역에 속성이 새로 추가될 때 발생
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("ServletRequest 영역에 속성이 새로 추가되었습니다.");
		System.out.println("added = " + srae.getName() + " : " + srae.getValue());
    }
    
	// ServletRequest 영역의 속성이 삭제 될 때 발생
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println("ServletRequest 영역의 속성이 삭제되었습니다.");
		System.out.println("removed = " + srae.getName() + " : " + srae.getValue());
    }

	// ServletRequest 영역의 속성 값이 변경될 때 발생
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("ServletRequest 영역에 속성의 값이 변경되었습니다.");
		System.out.println("replaced = " + srae.getName() + " : " + srae.getValue());
    }
    
	// HttpSession 객체가 생성될 때 발생
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("HttpSession 객체가 생성 되었습니다.");
		System.out.println("session = " + se.getSession());
    }

	// HttpSession 객체가 소멸될 때 발생
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("HttpSession 객체가 소멸 되었습니다.");
		System.out.println("session = " + se.getSession());
    }

    // HttpSession에 새로 속성이 추가될 때 발생
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("HttpSession 영역에 속성이 새로 추가되었습니다.");
		System.out.println("added = " + se.getName() + " : " + se.getValue());
    }

	// HttpSession 영역의 속성이 삭제 될 때 발생
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("HttpSession 영역의 속성이 삭제되었습니다.");
		System.out.println("removed = " + se.getName() + " : " + se.getValue());
    }

	// HttpSession 영역의 속성 값이 변경될 때 발생
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("HttpSession 영역의 속성 값이 변경되었습니다.");
		System.out.println("replaced = " + se.getName() + " : " + se.getValue());
    }
	
}
