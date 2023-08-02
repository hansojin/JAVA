class Student{
	static String name;
	static int ban, no, kor, eng, math;
	int sum;
	double avg;
	Student(String name, int ban, int no, int kor, int eng, int math){
		this.name=name;
		this.ban=ban;
		this.no=no;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		sum=(kor+eng+math);
		getAverage();
	}
	public int getTotal(){
		return sum;
	}

	public float getAverage(){
		return (int)(sum/3f*10 + 0.5f)/10f;
	}
	public String info(){
		return name + "," + ban+ "," +no+ "," +kor+ "," +eng+ "," +math+ "," +getTotal()+ "," +getAverage();
	}
}

class Q5{
	public static void main(String args[]) {
		Student s = new Student("홍길동",1,1,100,60,76);
		System.out.println(s.info());
	}
}