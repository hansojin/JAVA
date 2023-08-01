import java.util.*;

class  Q13{

	public static char swap(char n1, char n2){
		return n1;
	}

	public static void main(String[] args) {
		String[] words = {"television", "computer", "mouse", "phone" };

		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<words.length;i++) {

			char[] q = words[i].toCharArray();
			for(int k=0;k<q.length;k++){
				int j = (int)Math.floor(Math.random()*(q.length));
				q[j]=swap(q[k],q[k]=q[j]);
			}

			System.out.printf("Q%d. Enter %s answer: ", i+1, new String(q));
			String answer =sc.nextLine();

			if(words[i].equals(answer.trim()))
				System.out.println("correct");
			else
				System.out.println("wrong");
			
		} 
	} 
}