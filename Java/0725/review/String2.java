import java.util.Scanner;

class String2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String[] arr = new String[5];

		for(int i=0;i<5;i++){
			System.out.print("문자열을 입력하세요 : " );
			String str=sc.nextLine();
			arr[i]=str;
		}
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				int num=arr[i].compareTo(arr[j]);
				if (num>0){
					String tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		for (String str : arr){
			System.out.println(str);
		}
	}
}