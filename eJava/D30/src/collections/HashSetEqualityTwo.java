package collections;

import java.util.HashSet;

class Nmb {
    private int Nmb;
    
    public Nmb(int n) {
        Nmb = n;
    }

    @Override
    public String toString() {
        return String.valueOf(Nmb);
    }

    @Override
    public int hashCode() {
        return Nmb % 3;
    }

    @Override
    public boolean equals(Object obj) {
        if(Nmb == ((Nmb)obj).Nmb)
            return true;
        else
            return false;
    }    
}

class HashSetEqualityTwo {
    public static void main(String[] args) {    
        HashSet<Nmb> set = new HashSet<>();
        set.add(new Nmb(7799));
        set.add(new Nmb(9955));
        set.add(new Nmb(7799));

        System.out.println("인스턴스 수: " + set.size());

        for(Nmb n : set)
            System.out.print(n.toString() + '\t');

        System.out.println();
    }
}


/*
실행결과
인스턴스 수: 2
9955	7799	

	HashSet<E>이 판단하는 동일 인스턴스의 기준은, Object 클래스에 정의되어 있는 다음 두 메소드의 호출 결과를 근거로 하기 때문이다.

	public boolean equals(Object obj)
	public int hashCode()

	Object 클래스에 정의되어 있는 hashCode와 equals 메소드는 다음과 같이 정의되어 있다.
	(참고로 Object 클래스의 hashCode 메소드는 인스턴스가 저장된 주솟값을 기반으로 반환 값이 만들어지도록 정의되어 있다.)

	"인스턴스가 다르면 Object 클래스의 hashCode 메소드는 다른 값을 반환한다."
	"인스턴스가 다르면 Object 클래스의 equals 메소드는 false를 반환한다."

	String 클래스는 문자열의 내용 비교가 이뤄지도록 hashCode와 equals를 적절히 오버라이딩하고 있다. 
	따라서 HashSet<E> 인스턴스에는 동일한 문자열을 지니는 String 인스턴스가 둘 이상 저장되지 않는다.
*/