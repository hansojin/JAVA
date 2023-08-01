class Prime3{
	public static void main(String[] args){
	
		for(int i=1;i<=100;i++){
			boolean flag = true;
			if (i<2)
				continue;
			for(int j=2;j<i;j++){
				if (i%j==0){
					flag=false;
					break;
				}	
			}
			if (flag) System.out.print(i+ " ");


		}
	}
}
