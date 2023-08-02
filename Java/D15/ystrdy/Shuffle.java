import java.util.Random;

class Shuffle{
	public static int swap(int n, int m){
		return n;
	}
	
	public static void main(String[] args){
		Random rand = new Random();
		int[] arr= new int[10];
		
		for (int i=0;i<arr.length;i++){
			arr[i]=i;
		}
		
		for (int i=arr.length-1;i>0;i--){
			int k = rand.nextInt(i+1);
			arr[k]= swap(arr[i],arr[i]=arr[k]);
		}

		for(int i : arr)
			System.out.print(i+ " ");
	}
}