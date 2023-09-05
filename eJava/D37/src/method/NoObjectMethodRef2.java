package method;

import java.util.function.ToIntBiFunction;

class IBux {
    private int n; 

    public IBux(int i) { n = i; }

    public int larger(IBux b) {
        if(n > b.n)
            return n;
        else
            return b.n;
    }
}

class NoObjectMethodRef2 {
    public static void main(String[] args) {
        IBux ib1 = new IBux(5);
        IBux ib2 = new IBux(7);

        // 두 상자에 저장된 값 비교하여 더 큰 값 반환
        ToIntBiFunction<IBux, IBux> bf = IBux::larger;
        int bigNum = bf.applyAsInt(ib1, ib2);
        System.out.println(bigNum);}
}

