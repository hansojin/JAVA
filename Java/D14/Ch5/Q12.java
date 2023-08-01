import java.util.*;

class  Q12{
	public static void main(String[] args) {
		String[][] words = {
			{"chair","의자"},			
			{"computer","컴퓨터"},	
			{"integer","정수"}		
		};

		Scanner scanner = new Scanner(System.in);
		int cnt=0;
		for(int i=0;i<words.length;i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);

			String tmp = scanner.nextLine();

			if(tmp.equals(words[i][1])) {
				System.out.printf("정답입니다.%n%n");
				cnt+=1;
			} else {
			   System.out.printf("틀렸습니다. 정답은 %s입니다.%n%n",words[i][1]);
			}

			System.out.println("전체 3문제 중 " + cnt +"문제 맞추셨습니다.");
		} // for
	} // main의 끝
}