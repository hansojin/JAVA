import java.util.Arrays;
import java.util.Scanner;

class BinarySearch{
	static int cnt = 0, idx=-1;
	
	public static int search(int[] num, int start, int end, int target){
		try{
			cnt+=1;
			int mid = (start+end)/2;
		
			if (num[mid]<target)
				search(num,mid+1,end,target);
			else if(num[mid]> target)
				search(num,start, mid-1,target);
			else if(num[mid]==target)
				idx=mid;
		} 
		catch(StackOverflowError e){
            		System.err.println("Target is not in array.");
        		}
	
		return idx;
	
	}		
	

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int[] num = {1, 3, 4, 5, 7, 10, 27, 39, 50, 92};
		Arrays.sort(num);

		int start = 0, end = num.length-1;
		int target = sc.nextInt();
		if(search(num, start, end, target)!=-1){
			System.out.println("num["+idx+"] : " + target + " try : " + cnt);
		}
		
	}
}