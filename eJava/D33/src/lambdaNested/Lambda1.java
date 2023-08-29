package lambdaNested;

interface Printable1 {
	void print(String s);
}

class Printer1 implements Printable1 {
	public void print(String s) {
		System.out.println(s);
	}
}

class Lambda1 {
	public static void main(String[] args) {
		Printable1 prn = new Printer1();
		prn.print("What is Lambda?");
	}
}