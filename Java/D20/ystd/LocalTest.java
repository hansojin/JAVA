interface Readable{
	public void read();
}

class Outer{
	private String name;
	
	public Outer(String name){
		this.name = name;
	}

	public Readable localCreate(final int num){
		class LocalClass implements Readable{
			public void read(){
				System.out.println(name);
				System.out.println(num);
			}
		}
		return new LocalClass();
	}
}

class LocalTest{
	public static void main(String[] args){

		Outer out = new Outer("JH");
		Readable local = out.localCreate(948);
		local.read();
	}
}