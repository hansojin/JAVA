package VectorTest;

public class PhoneInfo {
	private String name,phone;

	public PhoneInfo(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public void showPhoneInfo() {
		System.out.println(name + "\t" + phone);
	}

	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", phone=" + phone + "]";
	}
	

	
}
