class ArrInit{
	public static void main(String[] args){
		int[] numArr1 = {10, 20, 30};

		int[][] numArr2 = {
			{10, 20, 30},
			{40, 50, 60},
			{70, 80, 90}
		};

		int[][] numArr3 = {
			{10, 20},
			{30, 40, 50},
			{60, 70, 80, 90}
		};

		int[][] numArr4 = new int[3][];	// 행 크기는 지정하지 않고,
		numArr4[0] = new int[3];		// 각 행의 크기를 가변적으로 지정
		numArr4[1] = new int[4];
		numArr4[2] = new int[5];

		for(int i=0;i<numArr4.length;i++)
			System.out.println(numArr4[i].length);	//3 4 5

		/*
		자바에서 Array의 경우는 사이즈가 생성 할 때 지정한 크기로 고정되어 있으며, 
		생성한 후 사이즈를 가변적으로 늘리거나 줄일 수 없음

		가변적인 사이즈를 갖는 배열 형태를 원한다면 ArrayList와 같은 타입을 사용해야 함
		import java.util.ArrayList;
		ArrayList<String> colors = new ArrayList<>();
		colors.add("white");
		colors.add(0,"black"); // 0에 삽입
		colors.set(1,"red");	   // idx 1 해당값으로 지정
		colors.remove("black");

		*/
	}
}