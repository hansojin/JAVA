package phoneInfo;

import java.util.ArrayList;

public class PhoneBook {
	private static PhoneBook pb;
//	private PhoneInfo[] pInfo;
	private ArrayList<PhoneInfo> pInfo;

	private PhoneBook(int sizePhoneInfo){
//		pInfo = new PhoneInfo[sizePhoneInfo];
		pInfo = new ArrayList<PhoneInfo>();

	}
	public static PhoneBook getPhoneBookInst(int sizePhoneInfo){
		if(pb == null)
			pb = new PhoneBook(sizePhoneInfo);
		return pb;
	}
	public void inputPhoneInfo(PhoneInfo pInfo){
		int i = 0;
		
		for(i=0;i<this.pInfo.size();i++){
			if(this.pInfo.get(i).getName().compareTo(pInfo.getName()) > 0){
				break;
			}
		}
		this.pInfo.add(pInfo);
		
	}
	public void searchPhoneInfo(String name){
		int result = search(name);
		if(result != -1)
			pInfo.get(result).showPhoneInfo();
		else
			System.out.println("찾으시는 데이터가 없습니다.");
	}
	public void deletePhoneInfo(int idx){
		pInfo.remove(idx);
		System.out.println("삭제가 완료되었습니다.");
	}


	public int search(String name){
		for(int i=0;i<pInfo.size();i++){
			if(pInfo.get(i).getName().compareTo(name) == 0)
				return i;
		}
		return -1;		
	}

	public void showAllPhoneInfo(){
		for(int i=0;i<pInfo.size();i++)
			pInfo.get(i).showPhoneInfo();
	}
}
