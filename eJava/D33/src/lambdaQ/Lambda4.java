package lambdaQ;

interface Printtable {
    void print(String s);
}

class Lambda4 {
    public static void ShowString(Printtable p, String s) {
        p.print(s);
    }

    public static void main(String[] args) {
        ShowString(s->System.out.println(s), "What is Lambda?");
    }
}

/*
Q. 출력 결과가 다음과 같이 나오도록 ShowString에 적절한 인자를 전달하시오.
>> What is Lambda?
*/
