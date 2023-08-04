class Adder{
	public static int val=0;
		
	public void add(int num){
		val+=num;
	}
}

class AdderFriend extends Adder{
	public void friendAdd(int num){
		val+=num;
	}
	public void showVal(){
		System.out.println(val);
	}
}

class StaticInheritance{	
	public static void main(String[] args){
		Adder ad=new Adder();
		AdderFriend af=new AdderFriend();
		ad.add(1);		// 1
		af.friendAdd(3);		// 4
		AdderFriend.val+=5;	// 9
		af.showVal();		
	}
}