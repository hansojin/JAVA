class SCE1{
	public static void main(String[] args){
		int n1=0, n2=0;

		if ((n1=n1+10) > 10 && (n2=n2+10) > 10)
			System.out.println("good");

		if ((n1=n1+10) > 10 || (n2=n2+10) > 10)
			System.out.println("nice");			// output : nice 

		System.out.println("n1 : " + n1 + "\tn2: " + n2); 	// 20 0
		
		
	}
}
