package util;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionList collectionList = factory.getBean("collectionList", CollectionList.class);
		List<String> addressList = collectionList.getAddressList();
		for(String str: addressList)
			System.out.println(str);
		
		CollectionSet collectionSet = factory.getBean("collectionSet", CollectionSet.class);
		Set<String> addressSet = collectionSet.getAddressList();
		for(String str:addressSet)
			System.out.println(str);
		
		CollectionMap collectionMap = (CollectionMap) factory.getBean("collectionMap");
		Map<String, String> addressMap = collectionMap.getAddressList();
		for(String key:addressMap.keySet()) {
			String value = addressMap.get(key);
			System.out.println(key+" : " +value);
		}
		
		CollectionProperties collectionProperties = (CollectionProperties) factory.getBean("collectionProperties");
		Properties addressP = collectionProperties.getAddressList();
		for(Object key : addressP.keySet() ){
			System.out.println( key +" : "+ addressP.getProperty(key.toString()) );
		}
		
		factory.close();
	}

}
