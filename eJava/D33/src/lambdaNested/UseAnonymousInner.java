package lambdaNested;

interface Priintable {
	void print();   
}

class Paeper {
	private String con;
	public Paeper(String s) { 
		con = s;
	}

	public Priintable getPrinter() {
		return new Priintable() {
			public void print() {
				System.out.println(con); 
			}
		};
	}
}

class UseAnonymousInner  {
	public static void main(String[] args) {
		Paeper p = new Paeper("서류 내용: 행복합니다.");
		Priintable prn = p.getPrinter();
		prn.print();
	}
}
