class Outer{
	private String name;
	private int num;
	
	public Outer(String name){
		this.name = name;
		num = 0;
	}
	public void whoRU(){
		num+=1;
		System.out.println(name + "  " + num);
	}
	class Inner{
		public Inner(){
			whoRU();
		}
	}
}

class InnerTest{
	public static void main(String[] args){
		Outer one = new Outer("one");
		Outer two = new Outer("two");
	
		one.whoRU();			// one 1
		two.whoRU();			// two 1
		
		Outer.Inner inO = one.new Inner();	// one 2
		Outer.Inner inT = two.new Inner();	// two 2
		Outer.Inner inF = two.new Inner();	// two 3

	}
}