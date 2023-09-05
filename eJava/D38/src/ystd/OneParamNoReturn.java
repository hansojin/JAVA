package ystd;

interface Printable {
    void print(String s);    // 매개변수 하나, 반환형 void
}

class OneParamNoReturn {
    public static void main(String[] args) {
        Printable p = s->System.out.println(s);
        p.print("Lambda exp one.");
    }
}