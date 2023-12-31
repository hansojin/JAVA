package ystd;

interface Printable {
    void print();   
}

class Papers {
    private String con;
    public Papers(String s) { con = s; }

    /*
    public Printable getPrinter() {
        class Printer implements Printable {
            public void print() { System.out.println(con); }
        }
        
        return new Printer();
    }
    */
    public Printable getPrinter() {
    	return new Printable() {
    		public void print() { System.out.println(con); }
    	};
    }
}

class UseLocalInner {
    public static void main(String[] args) {
        Papers p = new Papers("서류 내용: 행복합니다.");
        Printable prn = p.getPrinter();
        prn.print();
    }
}