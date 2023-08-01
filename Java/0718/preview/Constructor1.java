public class Constructor1{
	int x;
	public Constructor1(int y){
		x=y;
	}
	
	public static void main(String[] args){
		Constructor1 myObj = new Constructor1(5);
		System.out.println(myObj.x);
	}
}