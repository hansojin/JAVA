interface Readable{
	public void read();
}

class Outer{
	private String name;
	
	public Outer(String name){
		this.name = name;
	}

	public Readable localCreate(final int num){
		return new Readable(){
			public void read(){
				System.out.println(name);
				System.out.println(num);
			}
		};
		
	}
}

class LocalAno{
	public static void main(String[] args){
		Outer out = new Outer("JH");
		Readable local = out.localCreate(948);
		local.read();
	}
}