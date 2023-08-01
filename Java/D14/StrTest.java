class StrTest{
	public static void main(String[] args){
		for(String str: args)
			System.out.println(str);
	}
}

/*

javac StrTest.java
java StrTest aaa bbb 
라고 하면, args[0]="aaa", args[1]="bbb" 가 들어가서 
출력이 aaa\nbbb 가 된다.

*/