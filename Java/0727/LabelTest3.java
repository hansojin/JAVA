public class LabelTest3 {
	public static void main(String[] args) {
		Loop1 : 
			for(int i=2;i<=9;i++) {	
				for(int j=1;j<=9;j++) {
					if(j==5)
						continue Loop1;
					System.out.println(i+"*"+ j +"="+ i*j);
				}
				System.out.println();
			}
	}

}

/*
중간에 println()이 실행이 안돼
j==5에서 바로 i로 올라가니까

2*1=2
2*2=4
2*3=6
2*4=8
3*1=3
3*2=6
3*3=9
3*4=12
...
9*1=9
9*2=18
9*3=27
9*4=36

*/