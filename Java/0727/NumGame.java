class NumGame{
	public static void main(String[] args){
		for (int i=1;i<=100; i++){
			String num = String.valueOf(i);
			System.out.print(i + " ");
			for (int j=0;j<num.length();j++){
				char ch = num.charAt(j);
				if (ch=='3' || ch=='6' || ch=='9')
					System.out.print("*");
			}
			System.out.println();
		}

	}
}
