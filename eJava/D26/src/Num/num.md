**수학관련 기능의 제공을 위한 Math 클래스**
- Math 클래스는 모든 멤버가 static으로 선언되어 있는, 수학관련 기능의 제공을 위해 정의된 클래스일뿐, 인스턴스의 생성을 목적으로 정의된 클래스는 아니다.

---

**java.util.Random 클래스**

난수를 얻는 방법을 생각하면 Math.random()이 떠오를 것이다. 

이 외에도 Random클래스를 사용하면 난수를 얻을 수 있다. 

사실 Math.random()은 내부적으로 Random클래스의 인스턴스를 생성해서 사용하는 것이므로 둘 중에서 편한 것을 사용하면 된다.

```
double randNum = Math.random();					//내부적으로 Random클래스의 인스턴스를 생성해서 사용하는 것
double randNum = new Random().nextDouble();		// 위의 문장과 동일
```

예를 들어 1~6사이의 정수를 난수로 얻고자 할 때는 다음과 같다.

```
int num = (int)(Math.random() * 6) + 1;
int num = new Random().nextInt(6) + 1;	// nextInt(6)은 0~5 사이의 정수를 반환
```

Math.random()과 Random의 가장 큰 차이점이라면, 종자값(seed)을 설정할 수 있다는 것이다. 

종자값이 같은 Random인스턴스들은 항상 같은 난수를 같은 순서대로 반환한다.

종자값은 난수를 만드는 공식에 사용되는 값으로 같은 공식에 같은 값을 넣으면 같은 결과를 얻는 것처럼 같은 종자값을 넣으면 같은 난수를 얻게 된다.

|Random 클래스 메소드|반환|
|------|---|
|boolean nextBoolean()|boolean형 난수 반환|
|int nextInt()|int형 난수 반환|
|long nextLong()|long형 난수 반환|
|int nextInt(int n)|0 이상 n 미만의 범위 내에 있는 int형 난수 반환|
|float nextFloat()|0.0 이상 1.0 미만의 float 형 난수 반환|
|double nextDouble()|0.0 이상 1.0 미만의 double 형 난수 반환|

컴퓨터가 생성하는 난수를 가리켜 'Pseudo-random number'라 하는데, 이는 '가짜 난수'라는 뜻이다.

---

1. short 그리고 int와 같은 정수 자료형의 문제점은 매우 큰 수의 표현이 불가능하다는데 있고, float그리고 double과 같은 실수 자료형의 문제점은 정밀한 값의 표현이 불가능해 항상 오차가 존재한다는데 있다. 자바는 이러한 문제점의 해결을 위해서 **BigInteger** 클래스와 **BigDecimal** 클래스를 제공하고 있다.

2. Wrapper 클래스의 static 변수를 이용하여 가장 큰 수와 가장 작은 수를 출력하시오.
- **Long.MAX_VALUE** , **Long.MIN_VALUE**

3. 컴퓨터의 현재시간을 기준으로, 1970년 1월1일 자정 이후로 지나온 시간을 밀리 초(1/1000초) 단위로 계산해서 반환하는 메소드는?
- **System.currentTimeMillis()**

4. 매개변수 없는 난수 발생의 생성자의 원리는?

```
public Random(){
	this(System.currentTimeMillis());	// 씨드 값을 전달받는 또 다른 생성자의 호출
}
```

	API 문서에서는 "Random의 생성자가 호출될 때, 이전에 호출될 때와 전혀 다른 씨드 값이 설정된다.

	Math 클래스에 정의되어 있는 random 메소드는 Random 클래스의 nextDouble 메소드와 마찬가지로 0.0 이상 1.0 미만의 double 형 난수를 반환한다. 물론 실행할 때마다 새로운 씨드 값이 설정되기 때문에, 실행할 때마다 다른 유형의 난수가 생성된다.

5. *[참고] "08:45"와 "11:24"은 시간정보로 8시 45분과 11시24분을 의미하는 문자열 정보이다. 시 정보와 분 정보는 콜론을 기준으로 나눠져 있다. 즉 위의 문자열에서는 콜론이 '구분자(delimiter)'이다. 그리고 **구분자를 기준으로 나뉘어지는 문자열 정보** 를 가리켜 **토큰(token)** 이라 한다.*

6. 다음 **토큰 반환** 할 때 쓰는 메소드
> public String nextToken()

7. **반환할 토큰이 남았는지 확인** 하는 메소드
> public boolean hasMoreTokens()
