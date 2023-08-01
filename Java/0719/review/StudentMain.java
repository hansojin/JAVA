class Student{
	String department;
	int studentNumber;

	public void init(String department, int studentNumber){
		this.department = department;
		this.studentNumber = studentNumber;
		printState();
	}
	public void printState(){
		System.out.println(department + "\t" + studentNumber);
	}
}

class StudentMain{
	public static void main(String[] args){
		Student s1 = new Student();
		s1.init("sw", 201920753);
		Student s2 = new Student();
		s2.init("media", 201920702);
	}
}