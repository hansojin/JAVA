package Phone;

public class PhoneInfo {
	private String name;
	private String phone;
	
	public PhoneInfo(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	
	public void showInfo() {
		System.out.print(name + " "+phone+ " ");
	}
	
	
}
