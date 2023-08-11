package Phone;

public class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private int year;
	
	public PhoneUnivInfo(String name, String phone, String major, int year) {
		super(name, phone);
		this.major = major;
		this.year = year;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.print(major+ " " + year);
	}

}
