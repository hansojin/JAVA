package method;

interface SMaker {
    String make(char[] ar);
}

class StringMaker {
    public static String chsToString(char[] a, SMaker m) {
        return m.make(a);
    }

    public static void main(String[] args) {
        SMaker sm = (ar) -> {
            return new String(ar);
        };
        
        char[] src = {'R', 'o', 'b', 'o', 't'};        
        String str = chsToString(src, sm);
        System.out.println(str);	//Robot
    }
}


// Function<T, R>    R apply(T t)
/*

������ ����

���ٽ��� �ۼ��ϴ� ���� �ν��Ͻ��� �����ϰ� ���� ���� ���� ��ȯ�ؾ� �ϴ� ��찡 �ִ�. �׸��� �̷��� ��쿡�� '�޼ҵ� ����' ����� �� �� �ִ�.

�� ���������� String Ŭ������ ���� �����ڸ� �̿��� String �ν��Ͻ��� ������ ���̰� �ִ�.

>> public String(char[] value)

���� �� �������� �߿��� ���� ���� �����ڰ� �ƴ� ���� ���ٽ��̴�.

Function<char[], String> f = ar ->{
	return new String(ar);
};

�켱 �� ���ٽ��� ������ ���� ���� �� �ִ�.

Function<char[], String> f = ar -> new String(ar);

�׸��� ���� ������ ������ ���� �޼ҵ� ���� ������� �ٲ� �� �ִ�. 

Function<char[], String> f = ar -> new String(ar);
	-> Function<char[], String> f = String::new;	// ������ ���� ���
	
�����ϸ�, ���ٽ��� �̷�� ������ '�ܼ��� �ν��Ͻ��� ���� �� ���� ���� ��ȯ'�� ���, �̸� ���� ������ �޼ҵ� ������ �ٲ� �� �ִ�.

>> ClassName::new

�̹����� �̷��� ������ ������ ������ ������ �����غ��� ���� ���� �ڵ带 ����.

public static void main(String[] args){
	Function<char[], String> f = String::new;
	...
	String str = f.apply(src);
	...
}

���� �ڵ忡�� f�� ���� ����� String::new�̹Ƿ�, f�� String�� �����ڸ� �����ϰ� �Ǵµ�,
�������� f�� �ڷ����� Function<char[], String>�̹Ƿ� �Ű����� ���� char[]�� ���� �����ڸ� �����ϰ� �ȴ�.

>> public String(char[] value)

���� ���Ŀ� ���� ������ �����ϰ� �Ǹ�,

String str = f.apply(src);

���� �������� apply �޼ҵ尡 ȣ��ȴ�. (�Ʒ� �ڵ�� �޼ҵ� ���ǰ� �ƴϴ�. apply�� ȣ��� �� ����Ǵ� ������ ǥ���� ���̴�.) �׸��� �ٽ� �ѹ� �������� �̴� �������� ����̴�.

apply(src) {
	new String(src);
}

*/
