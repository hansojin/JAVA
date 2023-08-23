package ystd;

class Bx<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

class BoundedWildcardDemo {
    public static void addBx(Bx<? super Integer> b1, Bx<? extends Integer> b2, Bx<? extends Integer> b3) {
        b1.set(b3.get() + b2.get());	// 프로그래머의 실수가 있는 부분
    }

    public static void main(String[] args) {
        Bx<Integer> Bx1 = new Bx<>();
        Bx1.set(24);
        Bx<Integer> Bx2 = new Bx<>();
        Bx2.set(37);        
        Bx<Integer> result = new Bx<>();
        result.set(0);

        addBx(result, Bx1, Bx2);    // result에 24 + 37의 결과 저장     
        System.out.println(result.get());    // 61 출력 
    }
}
