package Num;

import java.util.Random;

class RandomPseudo {
	public static void main(String[] args){
		Random rand=new Random(12);
		
		for(int i=0; i<10; i++)
			System.out.println(rand.nextInt(1000));
	}
}

/*
Random rand = new Random(12);
Random 클래스의 인스턴스 생성 과정에서 생성자에 정수 12를 전달하고 있다. 
이 값은 난수를 생성하는 과정에 있어서 씨앗으로 사용이 된다. 
그러나 컴퓨터에서 생성하는 난수는 근거, 또는 재료가 되는 하나의 숫자를 기반으로 만들어지도록 알고리즘이 설계되어 있다. 
따라서 이 숫자를 가리켜 '씨앗 값(seed number)' 또는 영어 발음 그대로 '씨드 값'이라 한다.

따라서 12라는 시드값을 넣고 출력하면, 코드를 돌려도 같은 랜덤값이 나옴
*/