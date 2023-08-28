package collectionsCh11;

import java.util.*;

class Std {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	Std(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	int getTotal() {
		return kor+eng+math;
	}
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
	public String toString() {
		return name
				+","+ban
				+","+no
				+","+kor
				+","+eng
				+","+math
				+","+getTotal()
				+","+getAverage()
				;
	}
	
} 

class BanNoAscending implements Comparator<Std>{
	int ret=0;
	@Override
	public int compare(Std s1, Std s2) {
		if (s1.ban<s2.ban)
			ret=-1;
		else if (s1.ban==s2.ban)
			if(s1.no>s2.no)
				ret=1;
			else if(s1.no==s2.no)
				ret=0;
			else
				ret=-1;
		else
			ret=1;
		return ret;
	}
}

class Exercise11_7 {
	public static void main(String[] args) {
		ArrayList<Std> list = new ArrayList<>();
		list.add(new Std("이자바",2,1,70,90,70)); 
		list.add(new Std("안자바",2,2,60,100,80)); 
		list.add(new Std("홍길동",1,3,100,100,100)); 
		list.add(new Std("남궁성",1,1,90,70,80)); 
		list.add(new Std("김자바",1,2,80,80,90)); 
		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}