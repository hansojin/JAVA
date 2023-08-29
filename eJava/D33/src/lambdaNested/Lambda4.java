package lambdaNested;

interface Printable4 {
	void print(String s);
}

class Lambda4 {
	public static void ShowString(Printable4 p, String s) {
		p.print(s);
	}

	public static void main(String[] args) {
		ShowString((s) -> { System.out.println(s); }, "What is Lambda?");
	}
}