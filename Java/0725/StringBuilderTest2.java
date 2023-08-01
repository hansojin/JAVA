class StringBuilderTest2{
	public static void main(String[] args){

		StringBuilder strBuf=new StringBuilder("AB");
		System.out.println(strBuf + " " + strBuf.length());		//AB 2
		strBuf.append(25);			
		System.out.println(strBuf + " " + strBuf.length());		//AB25 4
		strBuf.append('Y').append(true);	
		System.out.println(strBuf + " " + strBuf.length());		//AB25Ytrue 9
		
		strBuf.insert(2, false);		
		System.out.println(strBuf + " " + strBuf.length());		//ABfalse25Ytrue 14
		strBuf.insert(strBuf.length(), 'Z');	
		System.out.println(strBuf + " " + strBuf.length());		//ABfalse25trueZ 15
	}
}