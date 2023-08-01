import java.util.Arrays;

public class NumShuffle {
	public static int swap(int n1, int n2){
		return n1;
	}

	public static void main(String[] args) {
		int[] num = new int[10];
		for(int i=0;i<num.length;i++){
			num[i] = i;
		}
		for (int i = num.length - 1; i > 0; i--) {
			int j = (int)Math.floor(Math.random() * (i + 1)); 
			num[j]=swap(num[i],num[i]=num[j]);
		}

		System.out.println(Arrays.toString(num));


		// 해당 알고리즘을 이용해서 3자리수 난수 만들기
		int len=3;
		String numStr = "";
		int rNum=0;
		
		for(int i=0;i<len;i++){
			numStr+=num[i];
		}
		rNum=Integer.parseInt(numStr);
		System.out.println(rNum);
	}
}

// 피셔-예이츠 셔플 알고리즘은 배열 끝 요소부터 시작해 앞으로 하나씩 나아가면서 
// 해당 요소 앞에 있는 임의의 요소와 해당 요소를 바꿔치기하는 알고리즘