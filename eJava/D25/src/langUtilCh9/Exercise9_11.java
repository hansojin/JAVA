package langUtilCh9;

public class Exercise9_11 {
	public static void main(String[] args) {
		int start = Integer.parseInt(args[0]);
		int end = Integer.parseInt(args[1]);
		for(int i=start;i<=end;i++) {
			for(int j=1;j<10;j++) {
				System.out.printf("%d*%d=%d",i,j,i*j);
			}
			System.out.println();
		}
	}
}
