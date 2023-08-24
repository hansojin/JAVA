package ystdPhoneInfo;
public class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private int year;

	PhoneUnivInfo(String name ,String phone, String major, int year)
	{
		super(name, phone);
		this.major = major;
		this.year = year; 
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("���� : " + major);
		System.out.println("�г� : " + year);
	}
}