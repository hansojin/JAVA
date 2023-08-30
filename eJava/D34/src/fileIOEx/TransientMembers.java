package fileIOEx;

import java.io.*;

class PersonalInfo implements Serializable{
	String name;
	int age;
	transient String secretInfo;
	transient int secretNum;

	public PersonalInfo(String name, String sInfo, int age, int sNum){
		this.name=name;
		secretInfo=sInfo;
		this.age=age;
		secretNum=sNum;
	}
	public void showPersonInfo(){
		System.out.println("name: "+name);
		System.out.println("secret info: "+secretInfo);
		System.out.println("age: "+age);
		System.out.println("secret num: "+secretNum);
		System.out.println("");
	}
}

public class TransientMembers {
	public static void main(String[] args) {
		try(ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream("Personal.ser"))){
			PersonalInfo info = new PersonalInfo("JH", "myBaby", 28,948);
			info.showPersonInfo();
			out.writeObject(info);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(ObjectInputStream in = 
				new ObjectInputStream(new FileInputStream("Personal.ser"))){
			PersonalInfo recovInfo = (PersonalInfo) in.readObject();
			recovInfo.showPersonInfo();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
