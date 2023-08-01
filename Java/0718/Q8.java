class Q8{
	public static boolean prime(int n){
		boolean flag = true;
		for(int i=2;i<n;i++){
			if (n%i==0){
				flag=false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args){
		for (int i=2;i<=100;i++){
			if (prime(i)) 
				System.out.print(i + " ");
		}
		
	}
}
