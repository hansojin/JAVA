import java.util.Scanner;

class BinarySearch{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] num = {1, 3, 4, 5, 7, 10, 27, 39, 50, 92};
		int start = 0, end=num.length-1,cnt=0,target;
		
		System.out.print("Enter num : ");
		target = sc.nextInt();
		while(start<=end){
			int mid = (start+end)/2;
			cnt+=1;
			if(target>num[mid])
				start=mid+1;
			else if (target <num[mid])
				end=mid-1;
			else{
				System.out.println("TRY : " + cnt + " num[" + mid + "]");
				break;
			}
			
		}	
		if (start>end){
			System.out.println("NOT in array");
		}
	}	
}