### Wrapper 클래스

'Wrapper 클래스'라는 이름에는 '감싸는 클래스'라는 의미가 담겨있다.

---

**기본 자료형의 데이터를 감싸는 Wrapper 클래스**
|Wrapper 클래스의 종류|기본 생성자|
|---|---|
|Boolean|Boolean(boolean value)|
|Character|Character(char value)|
|Byte|Byte(byte value)|
|Short|Short(short value)|
|Integer|Integer(int value)|
|Long|Long(long value)|
|Float|Float(float value), Float(double value)|
|Double|Double(double value)|

위에서 보이듯이 모든 기본 자료형에 해당하는 Wrapper 클래스가 정의되어 있다.  그리고 위에서는 보이지 않고 있지만, Character 클래스를 제외한 모든 Wrapper 클래스에는 String의 참조 값을 인자로 받는 생성자들이 정의되어 있어서, 다음과 같이 문자열로 표현된 데이터를 기반으로 하는 인스턴스의 생성도 가능하다.

```
Interger num1 = new Integer("240");
Double num2 = new Double("12.257");
```

---

#### Boxing과 Unboxing

Wrapper 클래스의 가장 기본이 되는 두 가지 기능으로 Boxing과 Unboxing이 있다.

기본 자료형 데이터를 인스턴스화 시키는 작업을 가리켜 Boxing(≈상자에 담음)이라 한다. 

즉 **Boxing은 인스턴스의 생성에 의해서 이뤄진다.**

반면 인스턴스에 저장되어 있는 기본 자료형 데이터를 꺼내는 작업을 가리켜 **Unboxing** 이라 하는데, 이는 **Wrapper 클래스에 정의된 메소드의 호출에 의해서 이뤄진다.**

**각 클래스의 언박싱 메소드**
|클래스|method|
|---|---|
|Boolean|public boolean booleanValue()|
|Character|public char charValue()|
|Integer|public int intValue()|
|Long|public long longValue()|
|Double|public double doubleValue()|

```
class BoxingUnboxing{	
	public static void main(String[] args){
		Integer iValue=new Integer(10);		// deprecated API.
		Double dValue=new Double(3.14);		// deprecated API.
		
		System.out.println(iValue);
		System.out.println(dValue);
		
		iValue=new Integer(iValue.intValue()+10);
		dValue=new Double(dValue.doubleValue()+1.2);
		
		System.out.println(iValue);
		System.out.println(dValue);		
	}
}
```

*참고 : Wrapper 클래스는 산술연산을 위해 정의된 클래스가 아니다. 따라서 Wrapper 클래스의 인스턴스에 저장된 값은 변경이 불가능하다. 다만 위 예제에서 보인 것처럼, 증가된 값을 저장하는 새로운 인스턴스의 생성 및 참조만이 가능할 뿐이다.*

---

#### Auto Boxing & Auto Unboxing

자바 버전 5.0부터 Boxing과 Unboxing이 필요한 상황에서 이를 자동으로 처리하기 시작했다. (Auto Boxing & Auto Unboxing)

```
class AutoBoxingUnboxing{	
	public static void main(String[] args){
		Integer iValue=10; 		// Interger형 참조 변수에는 Integer형 인스턴스의 참조 값이 저장되어야 한다.
									// 그런데 이 문장에서는 정수 10을 저장하려 하고 있다. 이러한 경우에 정수 10을 바탕으로 Integer형 인스턴스가 자동으로 생성되고,
									// 이 인스턴스의 참조 값이 대신 저장된다. 그리고 이러한 현상을 가리켜 Auto Boxing이라 한다.	
		Double dValue=3.14;		// Auto Boxing
		
		System.out.println(iValue);	
		System.out.println(dValue);
		
		int num1=iValue;		// num1에 저장될 값으로 int형 데이터가 등장해야 하는데, Integer형 참조변수 iValue가 등장하였다. 
								// 이 경우에는 iValue.intValue()가 자동으로 호출되어, 그 반환 값이 변수 num1에 저장된다. 그리고 이러한 현상을 가리켜 Auto Unboxing이라 한다.
		double num2=dValue;	// Auto Unboxing
		
		System.out.println(num1);
		System.out.println(num2);
	}
}
```

위 예제에서 보이듯이 **Integer형 참조변수가 와야 할 위치에 int형 데이터가 오면 Auto Boxing** 이 진행된다. 

그리고 **int형 데이터가 와야 할 위치에 Integer형 참조변수가 오면 Auto Unboxing** 이 진행된다. 

이러한 Auto Boxing과 Auto Unboxing은 보다 다양한 상황에서 다양한 형태로 적용이 되어, 다음 예제에서 보이는 코드의 구성도 허용한다.

```
class AutoBoxingUnboxing2{	
	public static void main(String[] args){
		Integer num1=10;
		Integer num2=20;
		
		num1++;					// Unboxing과 Boxing이 동시에 진행된다.
								// num1 = Integer.valueOf(num1.intValue() + 1);
		System.out.println(num1);
		
		num2+=3;				// num2 = Integer.valueOf(num2.intValue() + 3);
		System.out.println(num2);	
		
		int addResult=num1+num2;
		System.out.println(addResult);
		
		int minResult=num1-num2;	
		System.out.println(minResult);	
	}
}
```

Wrapper 클래스는 산술연산을 위해 정의된 클래스가 아니라고 하였는데, 이 사실에는 변함이 없다. 

다만 이러한 Wrapper 클래스가 Auto Boxing과 Auto Unboxing으로 인해서 산술연산이 가능해졌을 뿐이다.

앞서 소개한 모든 래퍼 클래스는 다음 클래스를 상속한다.

```
java.lang.Number
```

그리고 이 클래스에는 다음의 추상 메소드들이 존재한다. (즉 Number도 추상 클래스이다)

```
public abstract int intValue()
public abstract long longValue()
public abstract double doubleValue()
```

따라서 이를 상속하는 Integer, Double과 같은 클래스들은 위의 메소드 모두를 구현하고 있기 때문에 어떠한 래퍼 인스턴스를 대상으로도 인스턴스에 저장된 값을 다양한 형태로 반환할 수 있다.

```
class NumberMethod {
    public static void main(String[] args) {
        Integer num1 = new Integer(29);
        System.out.println(num1.intValue());		// int 형 값으로 반환
        System.out.println(num1.doubleValue());	// double형 값으로 반환

        Double num2 = new Double(3.14);
        System.out.println(num2.intValue());		// int형 값으로 반환
        System.out.println(num2.doubleValue());	// double형 값으로 반환
    }
}
```
실행 결과
```
> 29
> 29.0
> 3
> 3.14
```

출력 결과를 보면 Double형 인스턴스에 저장된 값을 int형으로 반환할 경우 소수점 이하의 값이 삭제 되는 것을 알 수 있다. 그리고 래퍼 클래스에는 static으로 선언된 다양한 메소드들이 존재한다.

```
class WrapperClassMethod {
    public static void main(String[] args) {
	// 클래스 메소드를 토한 인스턴스 생성 방법 두 가지
        Integer n1 = Integer.valueOf(5);		// 숫자 기반 Integer 인스턴스 생성
        Integer n2 = Integer.valueOf("1024");	// 문자열 기반 Integer 인스턴스 생성
        
	// 대소 비교와 합을 계산하는 클래스 메소드
        System.out.println("큰 수: " + Integer.max(n1, n2));
        System.out.println("작은 수: " + Integer.min(n1, n2));
        System.out.println("합: " + Integer.sum(n1, n2));
        System.out.println();
        
	// 정수에 대한 2진, 8진, 16진수 표현 결과를 반환하는 클래스 메소드
        System.out.println("12의 2진 표현: " + Integer.toBinaryString(12));
        System.out.println("12의 8진 표현: " + Integer.toOctalString(12));
        System.out.println("12의 16진 표현: " + Integer.toHexString(12));
    }
}
```

실행 결과

```
> 큰 수: 1024
> 작은 수: 5
> 합: 1029

> 12의 2진 표현: 1100
> 12의 8진 표현: 14
> 12의 16진 표현: c
```


```
class Test {

	public static void main(String[] args) {
		Double n1 = Double.valueOf(5.5);
		Double n2 = Double.valueOf("7.7");
		
		System.out.println("큰 수 : " + Double.max(n1, n2));
		System.out.println("작은 수 : " + Double.min(n1, n2));
		System.out.println("합 : " + Double.sum(n1, n2));
		
	}

}
```

실행 결과

```
> 큰 수 : 7.7
> 작은 수 : 5.5
> 합 : 13.2
```

참고로 Integer와 Double에 정의된 max, min, sum 메소드는 기본 자료형의 값을 인자로 받는다. 즉 위의 예제에서는 이 메소드의 호출 과정에서 오토 언박싱이 발생하게 된다.