public class LabelTest4 {
	public static void main(String[] args) {
		Loop1 : 
			for(int i=2;i<=9;i++) {	
				for(int j=1;j<=9;j++) {
					if(j==5)
						continue;
					System.out.println(i+"*"+ j +"="+ i*j);
				} 
				System.out.println();
			}
	}	
}

// j==5 빼고 다 출력