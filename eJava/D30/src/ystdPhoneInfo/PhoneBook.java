package ystdPhoneInfo;

import java.util.HashSet;
import java.util.Iterator;

public class PhoneBook {
	private static PhoneBook pb;
	private HashSet<PhoneInfo> set;
	private Iterator<PhoneInfo> iter;

	private PhoneBook(int sizePhoneInfo)
	{
		set = new HashSet<PhoneInfo>();
	}
	public static PhoneBook getPhoneBookInst(int sizePhoneInfo)
	{
		if(pb == null)
			pb = new PhoneBook(sizePhoneInfo);
		return pb;
	}
	public void inputPhoneInfo(PhoneInfo pInfo){
		set.add(pInfo);
	}
	public void searchPhoneInfo(String name)
	{
		PhoneInfo pInfo = null;
		iter = set.iterator();
		boolean flag = false;
		while(iter.hasNext()) {
			pInfo=iter.next();
			if(pInfo.getName().equals(name)) {
				pInfo.showPhoneInfo();
				flag = true;
			}
		}
		if (flag == false)
			System.out.println("찾으시는 데이터가 없습니다.");
	}
	public void deletePhoneInfo(String phone)
	{
		PhoneInfo pInfo = null;
		iter = set.iterator();
		boolean flag = false;
		while(iter.hasNext()) {
			pInfo=iter.next();
			if(pInfo.getPhone().equals(phone)) {
				iter.remove();
				System.out.println("데이터가 삭제되었습니다.");
				flag = true;
				
			}
		}
		if (flag == false)
			System.out.println("찾으시는 데이터가 없습니다.");
		
	}


	

	public void showAllPhoneInfo(){
		iter = set.iterator();
		while(iter.hasNext())
			iter.next().showPhoneInfo();
	}
}
