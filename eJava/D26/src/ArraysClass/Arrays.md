## Arrays 클래스

Arrays에 정의된 메서드는 모두 **static 메서드** 이다.

**java.util.Arrays 클래스** 는 배열 조작에 도움을 주는 메소드들로 채워져 있다. 

따라서 이 클래스에 정의된 메소드들을 사용하면 배열의 복사, 비교, 정렬 및 탐색과 관련된 코드를 비교적 쉽게 작성할 수 있다.

---

#### 배열의 복사

배열 복사에 사용되는 Arrays 클래스의 메소드는 다음과 같다. 

모든 기본 자료형 배열에 대해 이 메소드가 오버로딩 되어 있으나 아래에서는 int형 배열에 대해 정의된 메소드만 보였다.

```
public static int[] copyOf(int[] original, int newLength)	// original에 전달된 배열을 첫 번째 요소부터 newLength의 길이만큼 복사
```

위 메소드는 **배열을 복사하여 '새로운 배열을 생성'하는 메소드** 이다. 

첫 번째 인자로 전달된 배열을 두 번째 인자로 전달된 길이만큼 복사하되 '새로운 배열을 생성'하여 복사하고, 생성된 배열의 참조 값을 반환한다.

```
import java.util.Arrays;

class CopyOfArrays {
    public static void main(String[] args) {
        double[] arOrg = {1.1, 2.2, 3.3, 4.4, 5.5};
     
        // 배열 전체를 복사하여 배열 생성
        double[] arCpy1 = Arrays.copyOf(arOrg, arOrg.length);
        
        // 배열의 세번째 요소까지만 복사하여 배열 생성 
        double[] arCpy2 = Arrays.copyOf(arOrg, 3);


        for(double d : arCpy1)
            System.out.print(d + "\t");
        System.out.println();


        for(double d : arCpy2)
            System.out.print(d + "\t");
        System.out.println();

    }
}

// 실행 결과
1.1	2.2	3.3	4.4	5.5	
1.1	2.2	3.3
```

배열의 일부만 복사하려면 Arrays 클래스의 다음 메소드를 사용하면 된다. 물론 이 메소드도 기본 자료형 배열 전부에 대해 오버로딩 되어 있다.

```
public static int[] copyOfRange(int[] original, int from, int to)	// original에 전달된 배열을 인덱스 from 부터 to 이전 요소까지 복사
```

예를 들어서 앞서 예제에서 선언한 다음 배열의 2.2가 저장된 요소부터 4.4가 저장된 요소까지 복사하기를 원한다면, 다음과 같이 문장을 구성하면 된다.

```
double[] arOrg = {1.1, 2.2, 3.3, 4.4, 5.5};
double[] arCpy2 = Arrays.copyOfRange(arOrg, 1, 4);
```

위의 문장에서 전달된 숫자 1과 4는 배열의 인덱스 정보이다. 그러나 인덱스 1부터 4까지의 복사가 아니라 4 이전까지의 복사를 의미한다는 점에 주의해야 한다. 

그리고 위의 예제와 달리 **배열을 새로 생성하지 않고 존재하는 배열에 복사를 하려는 경우** 에는 java.lang.System 클래스의 다음 메소드를 호출하면 된다.

```
public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)	// 배열 src의 srcPos에서 배열 dest의 destPos로 length 길이만큼 복사
```

```
class CopyOfSystem {
    public static void main(String[] args) {
        double[] org = {1.1, 2.2, 3.3, 4.4, 5.5};
        double[] cpy = new double[3];

        System.arraycopy(org, 1, cpy, 0, 3);

        for(double d : cpy)
            System.out.print(d + "\t");
        
        System.out.println();
    }
}

// 실행 결과
2.2	3.3	4.4
```

모든 기본 자료형 배열에 대해서뿐만 아니라 앞서 배열의 복사와 관련된 메소드들이, 모든 기본 자료형 배열을 대상으로 오버로딩 되어 있음을 언급하였는데, 이들 이외에도 특정 클래스의 인스턴스를 저장하고 있는 배열을 대상으로도 복사를 진행할 수 있도록 copyOf 메소드와 copyOfRange 메소드가 오버로딩 되어 있다.

---

#### 배열의 비교

배열의 내용 비교에 사용되는 Arrays 클래스의 메소드는 다음과 같다. 기본적으로 모든 기본 자료형의 배열에 대해 이 메소드가 오버로딩 되어 있으나 아래에서는 int형 배열에 대해 정의된 메소드만 보였다.

```
public static boolean equals(int[] a, int[] a2)	// 매개변수 a와 a2로 전달된 배열의 내용을 비교하여 true 또는 false 반환
```

이 메소드는 **두 배열에 저장된 데이터의 수, 순서, 그리고 내용이 같을 때 true를 반환** 한다.(배열의 길이가 다를 경우에는 false를 반환) 

이 메소드의 사용 예는 다음과 같다.

```
import java.util.Arrays;

class ArrayEquals {
    public static void main(String[] args) {
        int[] ar1 = {1, 2, 3, 4, 5};
        int[] ar2 = Arrays.copyOf(ar1, ar1.length);

        System.out.println(Arrays.equals(ar1, ar2));		// true
    }
}
```

그리고 이 메소드는 다음과 같이 Object형 배열에 대해서도 오버로딩 되어 있다.

```
public static boolean equals(Object[] a, Object[] a2)
```

이는 **인스턴스의 참조 값을 저장하고 있는 두 배열에 대해서 비교** 를 진행한다.

```
import java.util.Arrays;

class INum {
    private int num;
    
    public INum(int num) {
        this.num = num;
    }
}

class ArrayObjEquals {
    public static void main(String[] args) {
        INum[] ar1 = new INum[3];
        INum[] ar2 = new INum[3];
        
        ar1[0] = new INum(1);
        ar2[0] = new INum(1);

        ar1[1] = new INum(2);
        ar2[1] = new INum(2);

        ar1[2] = new INum(3);
        ar2[2] = new INum(3);

        System.out.println(Arrays.equals(ar1, ar2));	// false
    }
}
```

위 예제에서는 두 배열에 동일한 값으로 초기화된 서로 다른 인스턴스를 각각 저장하였다. 

그러나 배열의 비교 결과는 false이다. 이유는 Object 클래스에 정의되어 있는 equals 메소드가 다음과 같이 정의되어 있기 때문이다.

```
public boolean equals(Object obj){
	if(this == obj)	// 두 인스턴스가 동일 인스턴스이면
		return true;
	else
		return false;
}	
```

이렇듯 **Object 클래스에 정의된 equals 메소드는 참조 값 비교** 를 한다.

따라서 **배열의 참조 값 비교가 아닌 내용 비교가 목적이라면 다음과 같이 equals 메소드를 목적에 맞게 오버라이딩 해야 한다.**

```
import java.util.Arrays;

class INum {
    private int num;
    
    public INum(int num) {
        this.num = num;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this.num == ((INum)obj).num)
            return true;
        else
            return false;
    }
}

class ArrayObjEquals2 {
    public static void main(String[] args) {
        INum[] ar1 = new INum[3];
        INum[] ar2 = new INum[3];
        
        ar1[0] = new INum(1);
        ar2[0] = new INum(1);

        ar1[1] = new INum(2);
        ar2[1] = new INum(2);

        ar1[2] = new INum(3);
        ar2[2] = new INum(3);

        System.out.println(Arrays.equals(ar1, ar2));
    }
}
```

---

#### 배열의 정렬

배열의 정렬에 사용되는 Arrays 클래스의 메소드는 다음과 같다. 기본적으로 모든 기본 자료형의 배열에 대해 이 메소드가 오버로딩 되어 있으나 아래에서는 int형 배열에 대해 정의된 메소드만 보였다.

```
public static void sort(int[] a)	// 매개변수 a로 전달된 배열을 오름차순(Ascending Numberical Order)으로 정렬
```

이 메소드는 배열에 저장된 데이터를 오름차순으로 정렬한다.

```
import java.util.Arrays;

class ArraySort {
    public static void main(String[] args) {
        int[] ar1 = {1, 5, 3, 2, 4};
        double[] ar2 = {3.3, 2.2, 5.5, 1.1, 4.4};
        
        Arrays.sort(ar1);
        Arrays.sort(ar2);

        for(int n : ar1) 
            System.out.print(n + "\t");
        System.out.println();

        for(double d : ar2) 
            System.out.print(d + "\t");
        System.out.println();
    }
}


// 실행결과
1	2	3	4	5	
1.1	2.2	3.3	4.4	5.5	
```

그리고 이 메소드는 다음과 같이 Object 배열에 대해서도 오버로딩 되어 있다.

```
public static void sort(Object[] a)
```

이는 인스턴스의 **참조 값을 저장하고 있는 배열에 대한 정렬** 을 진행한다. 

그렇다면 순서상 인스턴스의 앞서고 뒤섬은 어떻게 판단을 할까? 

이는 인터페이스의 구현을 기반으로 프로그래머가 클래스 별로 결정하게 되어 있다.

```
interface Comparable{}
...
public int compareTo(Object o){}	// 메소드 구현을 통해 인스턴스의 순서 판단 기준을 결정
```

위 인터페이스에 존재하는 추상 메소드 compareTo의 구현 방법은 다음과 같다.
● 인자로 전달된 o가 작다면 양의 정수 반환
● 인자로 전달된 o가 크다면 음의 정수 반환
● 인자로 전달된 o와 같다면 0을 반환

```
// 나이 순으로 정렬 하려면
import java.util.Arrays;

class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }    

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;

        if(this.age > p.age)
            return 1;
        else if(this.age < p.age)
            return -1;
        else
            return 0;
/*
	Person p = (Person)o;
	return this.age - p.age;
*/
    }
    
    @Override
    public String toString() {
        return name + ": " + age;
    }
}

class ArrayObjSort {
    public static void main(String[] args) {
        Person[] ar = new Person[3];

        ar[0] = new Person("Lee", 29);
        ar[1] = new Person("Goo", 15);
        ar[2] = new Person("Soo", 37);

        Arrays.sort(ar);

        for(Person p : ar) 
            System.out.println(p);
    }
}

// 실행 결과
Goo: 15
Lee: 29
Soo: 37
```

---

*참고_ Comparable<T> 인터페이스*

*Comparable 인터페이스는 자바에 '제네릭(Generic)'이 도입되면서 Comparable<T> 인터페이스로 수정되었다. *

*그러나 지금도 기존 코드와의 호환성 유지를 위해 Comparable 인터페이스를 지원하고 있다.*

---

#### 배열의 탐색


배열의 탐색에 사용되는 Arrays 클래스의 메소드는 다음과 같다. 

이 메소드 역시 Arrays 클래스의 다른 메소드들과 마찬가지로 모든 기본 자료형의 배열에 대해 오버로딩 되어 있으나 아래에서는 int형 배열에 대해 정의된 메소드만 보였다.

```
public static int binarySearch(int[] a, int key)	// 배열 a에서 key를 찾아서 있으면 key의 인덱스 값, 없으면 0보다 작은 수 반환
```

```
import java.util.Arrays;

class ArraySearch {
    public static void main(String[] args) {
        int[] ar = {33, 55, 11, 44, 22};

        Arrays.sort(ar);			// 탐색 이전에 정렬이 선행되어야 한다.
        
        for(int n : ar)
            System.out.print(n + "\t");
        System.out.println();

        int idx = Arrays.binarySearch(ar, 33);
        System.out.println("Index of 33: " + idx);

    }
}

// 실행 결과
11	22	33	44	55	
Index of 33: 2
```

Arrays 클래스의 binarySearch 메소드는 '이진 탐색(Binary Search)'이라는 알고리즘을 기반으로 탐색을 진행한다. 

그런데 이는 **정렬된 상태의 데이터를 대상으로 하는 탐색 알고리즘** 이다. 

따라서 예제에서 보이듯이, 배열이 정렬된 상태가 아니라면 정렬을 한 이후에 binarySearch 메소드를 호출해야 한다. 

그리고 이 메소드는 다음과 같이 Object형 배열에 대해서도 오버로딩 되어 있다. 물론 이 메소드의 호출을 위해서는 배열이 정렬된 상태이어야 한다.

```
public static int binarySearch(Object[] a, Object key)
```

그렇다면 이 메소드가 key와 동일한 인스턴스를 찾았다고 판단하는 기준은 무엇일까? 

Comparable 인터페이스의 compareTo 메소드가 그 기준이다. 

**compareTo 메소드의 호출을 통해서 0이 반환되면 key에 해당하는 인스턴스를 찾았다고 판단** 한다.

```
import java.util.Arrays;

class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }    

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        return this.age - p.age;
    }
    
    @Override
    public String toString() {
        return name + ": " + age;
    }
}


class ArrayObjSearch {
    public static void main(String[] args) {
        Person[] ar = new Person[3];

        ar[0] = new Person("Lee", 29);
        ar[1] = new Person("Goo", 15);
        ar[2] = new Person("Soo", 37);

        Arrays.sort(ar);

        int idx = Arrays.binarySearch(ar, new Person("Who are you?", 37));
        System.out.println(ar[idx]);
    }
}

//실행결과
Soo: 37
```

예제에서는 다음 문장을 통해 탐색을 진행하고 있다.

```
int idx = Arrays.binarySearch(ar, new Person("Who are you?", 37));
```

문장의 내용만 놓고 보면 이름이 "Who are you?" 나이가 37인 Person 인스턴스를 찾는 것으로 보인다. 

그러나 탐색의 결과는 이름이 "Soo"이고 나이고 37이다. 

이러한 결과의 원인은 다음 메소드 정의에서 찾을 수 있다.

```
public int compareTo(Object o){
	Person p = (Person)o;
	return this.age - p.age;		// 나이가 같으면 0을 반환
}
```

정리하면, **binarySearch 메소드를 통해 인스턴스를 찾고자 하는 경우, 탐색의 대상이 되는 인스턴스들의 클래스는 Comparable 인터페이스를 구현한 상태이어야 한다.**

이는 compareTo 메소드의 구현 내용을 토대로 탐색이 진행되기 때문이다.