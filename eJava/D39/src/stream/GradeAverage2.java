package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

class ReporttCard {
    private int kor;    // 국어 점수
    private int eng;    // 영어 점수
    private int math;    // 수학 점수
    
    public ReporttCard(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;    
    }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
}


class GradeAverage2 {
    public static void main(String[] args) {
        ReporttCard[] cards = {
            new ReporttCard(70, 80, 90),
            new ReporttCard(90, 80, 70),
            new ReporttCard(80, 80, 80)
        };       

        Arrays.stream(cards)
        	.flatMapToInt(r -> IntStream.of(r.getKor(), r.getEng(), r.getMath()))
       		.average().ifPresent(System.out::println);
       	
     }
}

