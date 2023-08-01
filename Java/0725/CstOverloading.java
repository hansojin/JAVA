class Person2{
	private int perID;
	private int milID;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	
	public Person2(int perID, int milID, int bYear, int bMonth, int bDay){
		this.perID=perID;
		this.milID=milID;
		birthYear=bYear;
		birthMonth=bMonth;
		birthDay=bDay;
	}

	public Person2(int pID, int bYear, int bMonth, int bDay){

		this(pID, 0, bYear, bMonth, bDay);		
	
		/*

		위에 Person2를 호출하는거야	 
		(as, 매개변수가 5개인 생성자를 부르고있으니까)	
		
		메소드 내에서 생성자 호출은 "불가능" 하지만,
		생성자 내에서 생성자 호출은 "가능" !!!!!!!

		*/ 
	}

	public void showInfo(){
		System.out.println("민번: "+perID);
		System.out.println("생년월일: "+birthYear+"/"+birthMonth+"/"+birthDay);
		if(milID!=0)
			System.out.println("군번: "+milID+'\n');
		else
			System.out.println("군과 관계 없음 \n");
	}
}

class CstOverloading{
	public static void main(String[] args){
		Person2 man=new Person2(950123, 880102, 1995, 12, 3);
		Person2 woman=new Person2(990117, 1999, 01, 17);
		man.showInfo();
		woman.showInfo();
	}
}