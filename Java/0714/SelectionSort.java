import java.util.*;

class SelectionSort{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];

		for(int i=0;i<5;i++){
            	            num[i]=sc.nextInt();
            	}
	
		for (int i=0;i<4;i++){
			for (int j=i+1;j<5;j++){
				if (num[i]>num[j]){
					int tmp=num[i]; num[i]=num[j];num[j]=tmp;
				}
			}
		}

		for(int i=0;i<5;i++){
                   	     System.out.print(num[i]+" ");
            	}	
	}
}
