class Lv3{
	public static void main(String[] args){
		for(int i=0;i<9;i++){
			for(int  j=0;j<3;j++){
				int x=1;
				int y=i%3+1;
				System.out.print(x+"*"+y+"="+x*y+"\t");
			}
			System.out.println();
		}
	}
}