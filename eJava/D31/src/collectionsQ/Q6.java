package collectionsQ;

import java.util.HashMap;
import java.util.Map.Entry;

public class Q6 {
	public static void main(String[] args) {
		HashMap<String,Integer> score = new HashMap<>();
		
		score.put("김자바", 90);
		score.put("김자바", 100);
		score.put("이자바", 100);	
		score.put("강자바", 80);
		score.put("안자바", 90);
		
		int total=0, maxScore=0, minScore=100, tmpScore =0;
		for(Entry<String,Integer> set : score.entrySet()) {
			System.out.println(set.getKey() + " " + set.getValue());
			tmpScore=set.getValue();
			total+=tmpScore;
			maxScore=maxScore<tmpScore?tmpScore:maxScore;
			minScore=minScore>tmpScore?tmpScore:minScore;
		}
		System.out.println();
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/score.size());
		System.out.println("최고점 : " + maxScore);
		System.out.println("최저점 : " + minScore);
	}
}
