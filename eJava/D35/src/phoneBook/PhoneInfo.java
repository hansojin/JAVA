package phoneBook;

import java.io.Serializable;

public class PhoneInfo implements Comparable<PhoneInfo>,Serializable{

	private static final long serialVersionUID = -2588730398695250029L;
	private String name;
	private String phoneNumber;
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void printCurrentState(){
		System.out.println("이름 : "  + name);
		System.out.println("전화번호 : "  + phoneNumber);
	}

	@Override
	public int compareTo(PhoneInfo pInfo) {
		return phoneNumber.compareTo(pInfo.phoneNumber);
	}
	
}