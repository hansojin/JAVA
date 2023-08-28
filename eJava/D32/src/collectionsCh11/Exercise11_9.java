package collectionsCh11;

import java.util.*;
class StuNine implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // 총점
	int schoolRank; // 전교등수
	int classRank; // 반등수

	StuNine(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor+eng+math;
	}
	int getTotal() {
		return total;
	}
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
	public int compareTo(Object o) {
		if(o instanceof StuNine) {
			StuNine cmp = (StuNine)o;
			return cmp.total-this.total;
		}
		else
			return -1;
	}
	public void setSchoolRank(int schoolRank) {
		this.schoolRank=schoolRank;
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
				+","+schoolRank 
				+","+classRank // 새로추가
				;
	}
} 

class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof StuNine && o2 instanceof StuNine) {
			StuNine s1 = (StuNine)o1;
			StuNine s2 = (StuNine)o2;
			int result = s1.ban-s2.ban;
			if (result==0)
				result = s2.total-s1.total;
			return result;
		}
		else 
			return -1;
	}
}
class Exercise11_9 {
	public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());
		int prevBan=-1;
		int prevRank = -1; 
		int prevTotal = -1; 
		int length = list.size();

		for(int i=0,n=0;i<length;i++,n++) {
			StuNine s = (StuNine)list.get(i);
			
			if (prevBan!=s.ban) {
				prevRank=-1;
				prevTotal=-1;
				n=0;
			}
			
			if(s.total==prevTotal) {
				s.classRank = prevRank;
			}
			else {
				s.classRank=n+1;
				
			}
			prevBan=s.ban;
			prevRank=s.classRank;
			prevTotal = s.total;
		}

	}
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		
		for(int i=0;i<length;i++) {
			StuNine s = (StuNine)list.get(i);
			
			if(s.total==prevTotal)
				s.schoolRank =prevRank;
			else
				s.schoolRank=i+1;
			prevRank = s.schoolRank;
			prevTotal=s.total;
		}
		
		
	}
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new StuNine("이자바",2,1,70,90,70)); 
		list.add(new StuNine("안자바",2,2,60,100,80)); 
		list.add(new StuNine("홍길동",1,3,100,100,100)); 
		list.add(new StuNine("남궁성",1,1,90,70,80)); 
		list.add(new StuNine("김자바",1,2,80,80,90)); 
		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator it = list.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}