package phoneInfoTreeSet;

public class PhoneInfo implements Comparable<PhoneInfo>{
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
	// TreeSet -> 알아서 오름차순 정렬 해줌  
	// 근데 여기에 compareTo 조건을 걸었으니까 phoneNumber 기준으로.
	
}