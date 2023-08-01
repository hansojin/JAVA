class Q4{
	public static void main(String[] args){
		for(int i=0;i<9;i++){
			for(int j=0;j<3;j++){
				int x=i/3*3+j+2;
				int y=i%3+1;
				if (x==10)
					break;
				System.out.print(x + "*" + y + "=" + x*y + "\t");
			}
			System.out.println();
			if (i%3==2)
				System.out.println();
		}
	}
}