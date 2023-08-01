import java.util.Scanner;

class PrivateStudent{
	private String name;
	private int id;

	void setId(int id){
		this.id = id;
		getId();
	}
	void getId(){
		System.out.println(id);
	}
	void setName(String name){
		this.name = name;
		getName();
	}
	void getName(){
		System.out.println(name);
	}
	
}

class PrivateStudentMain{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		PrivateStudent std = new PrivateStudent();
		System.out.print("Enter your student ID : ");
		int stdId = sc.nextInt();
		std.setId(stdId);
		System.out.print("Enter your name : ");
		String stdName = sc.next();
		std.setName(stdName);

	}
}