package lambdaNested;

interface Printable3 {
    void print(String s);
}

class Lambda3 {
    public static void main(String[] args) {
        Printable3 prn = (s) -> { System.out.println(s); };
        // lambda로 쓰려면 interface에 method는 하나여야 해 
        // 고로 method명 생략가능, 자료형 생략 가능 -> (s) 만 남고, 람다식임을 보여주기 위해 -> 를 넣어줌
        prn.print("What is Lambda?");
    }
}