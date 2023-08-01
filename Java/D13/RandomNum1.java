import java.util.*;

class RandomNum1{

	public static int swap(int n1,int n2){
		return n1;
	}

	public static void sortArr(int[] arr){
		for (int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if (arr[i]>arr[j])
					arr[j]=swap(arr[i],arr[i]=arr[j]);
			}
		}
	}

	public static void main(String[] args){
		Random rand = new Random();
		
		for(int j=0;j<5;j++){
			int[] lotto = new int[6];

			for (int i=0;i<lotto.length;i++){
				lotto[i]=(int)(Math.random()*(45)+1);
			}

			sortArr(lotto);

			for(int i=0;i<lotto.length-1;i++){
				if(lotto[i]==lotto[i+1]){
					lotto[i+1]+=1;
				}
			}
			System.out.printf("line %d : ",j+1);
			for(int num :lotto)
				System.out.print(num+"\t");
			System.out.println();
		}
	}
}