package streamTest;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;

class Twlve {
    private int kor;    // 국어 점수
    private int eng;    // 영어 점수
    private int math;    // 수학 점수
    
    public Twlve(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;    
    }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
}

public class Q12 {
	public static void main(String[] args) {
        Twlve[] cards = {
            new Twlve(98, 84, 90),
            new Twlve(92, 87, 95),
            new Twlve(85, 99, 93)
        };       
        
        boolean b = Arrays.stream(cards)
        		.mapToDouble(n->(n.getEng()+n.getKor()+n.getMath())/3)
        		.anyMatch(n->n>=90.0);
        System.out.println(b);
        if (b) {
        	boolean c = Arrays.stream(cards)
        			.mapToDouble(n->(n.getEng()+n.getKor()+n.getMath())/3)
        			.allMatch(n->n>=90.0);
        	System.out.println(c);
        }
        
    }
}
