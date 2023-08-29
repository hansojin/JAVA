package lambdaQ;

interface Prntable {
    void print(String s);
}
/*
class Prnt implements Prntable {
    public void print(String s) {
        System.out.println(s);
    }
}
Q1. Lambda1.java를 익명클래스로 바꿔보시오.

*/
class Lambda1 {
    public static void main(String[] args) {
        //Prntable prn = new Prnt();
    	Prntable prn = new Prntable() {
    		public void print(String s) {
    	        System.out.println(s);
    	    }
    	};
        prn.print("What is Lambda?");
        
        //Q2. Lambda1.java를 람다로 바꿔보시오.
        Prntable prn2 = s -> System.out.println(s);
        prn2.print("What is Lambda2?");
    }
}
