import java.util.Arrays;
import java.util.Scanner;

class BinarySearch2{
	static int cnt =0, mid=0;	
	public static int search(int[] num, int start, int end, int target){

		cnt+=1;
		mid = (start+end)/2;
		if(start<=end){
			if (num[mid]<target)
				return search(num,mid+1,end,target);
			else if(num[mid]> target)
				return search(num,start, mid-1,target);
			else
				return mid;
		}
		return -1;
	
	}		
	

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int[] num = {1, 3, 4, 5, 7, 10, 27, 39, 50, 92};
		Arrays.sort(num);

		int start = 0, end = num.length-1;
		int target = sc.nextInt();
		if(search(num, start, end, target)!=-1){
			System.out.println("num["+mid+"] : " + target + " try : " + cnt);
		}
		else{
			System.out.println("Target is not in array");
		}
		
	}
}