class Break1{
	public static void main(String[] args){
		int sum=0;
		for (int i=1;true;i++){
			sum+=i;
			if (sum>=5000)
				break;
		}
		System.out.println(sum);

	}
}
