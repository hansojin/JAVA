class Lv5{
	public static void main(String[] args){
		for(int i=0;i<9;i++){
			for(int  j=0;j<3;j++){
				int x=i/3*3+2+j;
				int y=i%3+1;
				System.out.print(x+"*"+y+"="+x*y+"\t");
		
			}
			System.out.println();
			if (i%3==2)	
				System.out.println();
			
		}
	}
}