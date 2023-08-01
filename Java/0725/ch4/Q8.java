public class Q8{
	public static void main(String[] args){
		for (int i=0;i<=10;i++){
			for(int j=0;j<=10;j++){
				if(2*i + 4*j==10){
					System.out.println(String.format("[%d,%d]",i,j));
				}
			}
		}
	}
}