package ystd;

interface Prntable {
    void print(String s);
}

class Lambda2 {
    public static void ShowString(Prntable p, String s) {
        p.print(s);
    }

    public static void main(String[] args) {
        ShowString(s->System.out.println(s),"What is lambda?");
    }
}

/*
Q. 출력 결과가 다음과 같이 나오도록 ShowString에 적절한 인자를 전달하시오.
>> What is Lambda?
*/