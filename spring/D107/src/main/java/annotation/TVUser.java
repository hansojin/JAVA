package annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
//		TV tv = (TV)factory.getBean("tv");
		LgTV tv = factory.getBean("tv", LgTV.class);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();	
		tv.powerOff();
		
		factory.close();
	}
}