package ystdPhoneInfo;
public class PhoneInfo {
	private String name;
	private String phone;

	PhoneInfo(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}
	public String getName()
	{
		return name;
	}
	public String getPhone()
	{
		return phone;
	}
	public void showPhoneInfo()
	{
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ��ȣ : " + phone);
	}
	public int hashCode() {
		return phone.hashCode();
	}
	public boolean equals(Object obj) {
		return ((PhoneInfo)obj).phone == this.phone;
	}
}