package Phone;

import java.util.Iterator;
import java.util.Vector;

public class PhoneBook {
	private static PhoneBook pb;
	private Vector<PhoneInfo> pInfoVec;
	
	public PhoneBook(int size) {
		pInfoVec = new Vector<PhoneInfo>(100);
	}
	
	public static PhoneBook getPhoneBookInst(int size) {
		if(pb==null)
			pb=new PhoneBook(size);
		return pb;
		
	}
	
	public void inputPhoneInfo(PhoneInfo pInfo) {
		int i=0;
		for (i=0; i<pInfoVec.size();i++) {
			if (pInfoVec.get(i).getName().compareTo(pInfo.getName())>0) 
				break;
		}
		pInfoVec.add(i, pInfo);
	}
	
	public void searchPhoneInfo(String name) {
		int result = search(name);
		if (result!=-1)
			pInfoVec.get(result).showInfo();
		else
			System.out.println("No data");
	}
	
	public void deletePhoneInfo(int idx) {
		pInfoVec.remove(idx);
		System.out.println("Data deleted");
	}
	
	public int search(String name) {
		for(int i=0;i<pInfoVec.size();i++) {
			if(pInfoVec.get(i).getName().compareTo(name)==0)
				return i;
		}
		return -1;
	}
	
	public void showAllPhoneInfo() {
		// Sol 1.
		for(int i=0;i<pInfoVec.size();i++) {
			pInfoVec.get(i).showInfo();
			System.out.println();
		}
		
		// Sol 2. 
		for(PhoneInfo info : pInfoVec) {
			info.showInfo();
			System.out.println();
		}
		
		// Sol 3.
		Iterator<PhoneInfo> itr = pInfoVec.iterator();
		//Iterator는 일회성이기 때문에, 한번 더 반복하고 싶다면 다시 호출해야 해
		while(itr.hasNext()) {
			itr.next().showInfo();
			System.out.println();
		}
		
	}
	
}
