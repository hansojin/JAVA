import java.util.Scanner;

class Q3{

	public static boolean check(char[] chs){
		boolean flag = false;
		if (chs.length!=2)
			return flag;
		for (int i=0;i<=1;i++){
			if (chs[i]>='1' && chs[i]<='9')
				flag = true;
			else{
				flag=false;
				return flag;
			}
			
		}
		return flag;
	}
	public static void main(String[] args){
		
		 byte[][] shipBoard = {
		          // 1  2  3  4  5  6  7  8  9
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 1
			{ 1, 1, 1, 1, 0, 0, 1, 0, 0 }, // 2
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 3
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 4
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
			{ 1, 1, 0, 1, 0, 0, 0, 0, 0 }, // 6
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 7
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 8
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0 }, // 9
		};
		
		String[][] result= new String[shipBoard.length][shipBoard[0].length];
		for (int i=0;i<result.length;i++){
			for(int j=0;j<result[i].length;j++){
				result[i][j]="";
			}
		}
	
		while (true){
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter number (00 for EXIT) :");
			String num = sc.nextLine();
			if (num.equals("00")){
				System.out.println("EXIT");
				break;
			}
			char[] chs = num.toCharArray();
			if (check(chs)){
				int x=chs[0]-'0'-1;
				int y=chs[1]-'0'-1;
				if (shipBoard[x][y] ==1)
					result[x][y]="O";
				else
					result[x][y]="X";
			}
			else{
				System.out.println("Enter right coordinate.");
			}

			for (String[] str : result){
				for(String i : str)
					System.out.print(i+" ");
				System.out.println();
			}
	
			
			
		 }
			
		
		
	}	
}