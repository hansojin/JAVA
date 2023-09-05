package ystd;

interface Callculate {
    int cal(int a, int b);
}

class TwoParamAndReturn {
    public static void main(String[] args) {
        Callculate c;
        
        c = (a,b)->a+b;
        System.out.println(c.cal(4, 3));
    }
}