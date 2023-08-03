import java.util.Scanner;

class Q7{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	
		String[][] word = {
			{"사과","apple"},
			{"바나나","banana"},
			{"고양이","cat"}
		};

		int cnt=0;
		for(int i=0;i<word.length;i++){
			System.out.printf("Q%d. %s : ",i+1, word[i][0]);
			String ans = sc.nextLine();
			ans=ans.trim();
			if(ans.equals(word[i][1])){
				System.out.println("correct");
				cnt+=1;
			}else
				System.out.printf("wrong\nAnswer : %s\n",word[i][1]);
		}
		System.out.println("You got "+ cnt+ " right among " + word.length+ " questions.");
		
	}
}