package streamTest;

import java.util.Arrays;
import java.util.stream.IntStream;

class SIX {
    private int kor;    // 국어 점수
    private int eng;    // 영어 점수
    private int math;    // 수학 점수
    
    public SIX(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;    
    }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
}


class Q6 {
    public static void main(String[] args) {
        SIX[] cards = {
            new SIX(70, 80, 90),
            new SIX(90, 80, 70),
            new SIX(80, 80, 80)
        };   
        
        Arrays.stream(cards)
        	.flatMapToInt(n->IntStream.of(n.getEng(), n.getKor(), n.getMath()))
        	.average().ifPresent(System.out::print);

     }
}
