public class Constructor2{
	int myBirth;
	String myName;
	public Constructor2(int birth,String name){
		myBirth=birth;
		myName=name;
	}
	
	public static void main(String[] args){
		Constructor2 myObj = new Constructor2(900408,"JH");
		System.out.println(myObj.myBirth + " " + myObj.myName);
	}
}