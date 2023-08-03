class Q1{
	public static void main(String[] args){
		
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[2]);
		String op = args[1];
		switch(op){
		case "+":
			System.out.print(n1+n2);
			break;
		case "-":
			System.out.print(n1+n2);
			break;
		case "*":
			System.out.print(n1*n2);
			break;
		case "/":
			System.out.print(n1/n2);
			break;
		default : 
			System.out.print("you enter wrong operator");
		}
		
	}	
}