class Q6{
	public static void main(String[] args){
		int cnt=0;
		for (int i=1;i<26;i++){
			System.out.print(i+"\t");
			cnt+=1;
			if (cnt%5==0)	
				System.out.println();
		}
	}
}
