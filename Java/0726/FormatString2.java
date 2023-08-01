class FormatString2{
	public static void main(String[] args){

		System.out.print("a \n");	
		System.out.print("b \r");	// 커서를 해당 줄 맨 처음으로 돌림
					// = 타자기처럼 첫 글자부터 덮어씀
		System.out.print("c \r\n"); 	
		System.out.print("d \n");
		
		// output : a \n c \n d \n
		
		/*
		\' _ '
		\" _ "
		\\ _ \
		\t _ tab
		\b _ backspace
		\n _ newline
		\r _ carriage return. ()	// 커서의 맨앞으로 이동
		\r\n _ newline
		*/ 
	}
}