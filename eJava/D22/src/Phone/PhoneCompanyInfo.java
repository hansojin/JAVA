package Phone;

public class PhoneCompanyInfo extends PhoneInfo {
	private String company;

	public PhoneCompanyInfo(String name, String phone, String company) {
		super(name, phone);
		this.company = company;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.print(company);
	}
	
	
}
