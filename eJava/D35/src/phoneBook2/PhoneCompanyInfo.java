package phoneBook2;

import java.io.Serializable;

public class PhoneCompanyInfo extends PhoneInfo implements Serializable{

	private static final long serialVersionUID = -3097819009990589984L;
	private String company;

	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}

	@Override
	public void printCurrentState() {
		super.printCurrentState();
		System.out.println("회사 : " + company);
	}
	

}