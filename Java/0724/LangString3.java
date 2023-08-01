// 임의의 문자열 5개를 입력받아 알파벳 순으로 정렬


import java.util.Scanner;

class LangString3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[5];
		
		for (int i=0;i<5;i++){
			System.out.print("문자열을 입력하시오 : ");
			arr[i]=sc.nextLine();
		}
	
		int num;	
		for (int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				num=arr[i].compareTo(arr[j]);
				if (num>0){
					String tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		for(String str : arr){
			System.out.println(str);
		}

	}	
}

