class AsciiCode{
	public static void main(String[] args){
		char ch = 'A';
		for (int i=0;i<26;i++){
			System.out.print(ch + " " + (int)ch+ "\t");
			ch++;
		}
		System.out.println();
		ch = 'a';
		for (int i=0;i<26;i++){
			System.out.print(ch + " " + (int)ch+ "\t");
			ch++;
		}
		System.out.println();
		ch = '0';
		for (int i=0;i<10;i++){
			System.out.print(ch + " " + (int)ch+ "\t");
			ch++;
		}
	}
}