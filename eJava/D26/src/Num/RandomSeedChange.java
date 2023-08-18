package Num;

import java.util.Random;

public class RandomSeedChange {
	public static void main(String[] args){
		Random rand=new Random(12);
		rand.setSeed(System.currentTimeMillis());
		// System.currentTimeMillis() : 현재시각을 밀리세컨드 단위로 반환
		
		for(int i=0; i<10; i++)
			System.out.println(rand.nextInt(1000));
	}
}


/*
매개변수 없는 난수 발생의 생성자의 원리는?
public Random(){
	this(System.currentTimeMillis());		// 씨드 값을 전달받는 또 다른 생성자의 호출
}
*/
