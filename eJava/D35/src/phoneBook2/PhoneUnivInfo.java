package phoneBook2;

import java.io.Serializable;

public class PhoneUnivInfo extends PhoneInfo implements Serializable{

	private static final long serialVersionUID = 4282122421843163765L;
	private String major;
	private int year;

	PhoneUnivInfo(String name ,String phone, String major, int year){
		super(name, phone);
		this.major = major;
		this.year = year; 
	}
	public void printCurrentState() {
		super.printCurrentState();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + year);
	}
}