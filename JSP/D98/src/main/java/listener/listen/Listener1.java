package listener.listen;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener1 implements ServletContextListener, ServletContextAttributeListener {

    public Listener1() {
    }
    
    // 톰캣이 구동될 때 실행
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("ServletContext 가 초기화 되었습니다.");
		System.out.println("init context = " + sce.getServletContext());
    }
    
    // 톰캣이 종료될 때 실행
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ServletContext 가 소멸 되었습니다.");
		System.out.println("dest context = " + sce.getServletContext());
    }

    // ServletContext 객체에 속성이 새로 추가될 때 실행
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("Context 영역에 값이 추가 되었습니다.");
		System.out.println("added = " + scae.getName() + " : " + scae.getValue());
    }

    // ServletContext 객체의 속성이 삭제될 때 실행
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("Context 영역에 값이 삭제 되었습니다.");
		System.out.println("removed = " + scae.getName() + " : " + scae.getValue());
    }
    
    // ServletContext 객체의 속성이 수정될 때 수정 '직전에' 실행
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println("Context 영역에 값이 변경 되었습니다.");
		System.out.println("replaced = " + scae.getName() + " : " + scae.getValue());		
    }

    
	
}
