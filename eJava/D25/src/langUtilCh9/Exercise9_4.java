package langUtilCh9;

class Exercise9_4 {
	static void printGraph(int[] dataArr, char ch) {
		for(int num : dataArr) {
			for (int i=0;i<num;i++) {
				System.out.print(ch);
			}
			System.out.println(num);
		}
	}
	public static void main(String[] args) {
		printGraph(new int[]{3,7,1,4},'*');
	}
}
