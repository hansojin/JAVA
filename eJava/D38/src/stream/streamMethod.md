## 중간 처리 메소드의 종류

![mid](https://github.com/hansojin/JAVA/assets/112622663/a7f26005-ac9a-41f6-9c4a-b20d1b659ec4)

위와 같이 **리턴 타입이 스트림이라면 중간 처리 메소드** 입니다. 또한, 소속된 인터페이스가 공통이라는 의미는 Stream, IntStream, LongStream, DoubleStream에서 모두 제공된다는 뜻입니다.

종류로는 필터링, 매핑, 정렬, 루핑이 있는데 하나씩 살펴보겠습니다.

---

### 필터링

필터링은 중간 처리 기능으로 **요소를 걸러내는 역할** 을 하는데, 필터링 메소드에는 distinct()와 filter()가 있습니다. 이들은 모든 스트림이 가지고 있는 공통 메소드이기도 합니다.

1. distinct()

* **distinct()** 메소드는 **중복을 제거** 하는데, Stream의 경우 Object.equals(Object)가 true이면 동일한 객체로 판단하여 중복을 제거하고, 나머지 IntStream, LongStream, DoubleStream은 동일값일 경우 중복을 제거합니다.
	
```
public static void main(String[] args) {
    List<String> names = Arrays.asList("이산", "진영", "이산", "이산", "별찬");
    names.stream()
      .distinct()
      .forEach(System.out::println);
  }
```

중복을 제거하므로 출력 결과는 이산, 진영, 별찬 3가지만 나올 것입니다. 참고로, forEach() 메소드는 최종 처리 메소드이지만, 출력을 위해서 잠시 사용을 하였고, 자세한 설명은 다음 시간에 할 예정입니다.

2. filter()

* filter() 메소드는 **원하는 기준으로 요소를 걸러내는 역할** 을 합니다. 여기서 원하는 기준은 **Predicate 형태를 매개값으로 주면**  됩니다. 그러면 Predicate가 **true를 리턴하는 요소만** 필터링하는 방식으로 작동합니다.

```
public static void main(String[] args) {
    List<String> names = Arrays.asList("이산", "진영", "이산", "이산", "별찬");
    names.stream()
        .distinct() // 중복 제거
        .filter(name -> name.equals("이산")) // 이산이라는 이름을 가진 이름만 리스트에 남겨 둠.
        .forEach(System.out::println);
  }
```

위 코드는 이산이라는 이름만 필터링해서 출력하는 예제입니다. 출력 결과는 "이산" 한번만 나올 것입니다.

---

### 매핑

매핑은 **스트림의 요소를 다른 요소로 대체하는 작업**을 말합니다. 스트림에서 제공하는 매핑 메소드는 flatMapXXX()와 mapXXX(), 그리고 asDOubleStream(), asLongStream(), boxed()가 있습니다.

1. flatMapXXX()

* flatMapXXX() 메소드는 Array나 Object로 감싸져 있는 모든 원소를 단일 원소 스트림으로 반환하는 역할을 하며, 매개변수로는 Function을 사용합니다. 그리고 내부적으로 T를 Stream<R> 형식인 스트림 형태로 매핑합니다.

```
ublic static void main(String[] args) {
    List<String> inputList = Arrays.asList("Hello", "world");
    long res = inputList.stream()
        .flatMap(data -> Arrays.stream(data.split("")))
        .count();
    System.out.println(res);
  }
```

inputList에는 "Hello"와 "world"를 원소로 갖습니다. 그리고 stream() 메소드를 통해 오리지널 스트림을 얻어오고 그 안에서 flatMap() 메소드를 사용하는 것을 알 수 있습니다.

현재 스트림의 요소로는 "Hello"와 "world"가 있는데, 각각 5개의 단일 원소 스트림으로 나뉘게 됩니다. 그래서 스트림 안에는 10개의 요소가 존재하게 됩니다.

위 코드에서 count()는 스트림의 요소를 반환하는 메소드로, 최종 연산 메소드에서 다룰 것이지만 flatMap() 메소드의 이해를 돕기 위해서 잠시 사용하였습니다. 그리고 출력 결과로는 10이 나오는 것을 알 수 있습니다.

2. mapXXX()

* mapXXX() 메소드는 단일 스트림의 원소를 매핑시킨 후 매핑시킨 값을 다시 스트림으로 변환하는 역할을 하며, 매개변수로는 Function이나 Operator을 사용합니다. 그리고 내부적으로 T를 R 형식으로 매핑하는데 flatMapXXX()과 다르게 스트림 외에 다른 형식으로 매핑이 가능합니다.

```
public static void main(String[] args) {
    List<String> inputList = Arrays.asList("Hello", "world");
    long res = inputList.stream()
        .flatMap(data -> Arrays.stream(data.split("")))
        .count();
    System.out.println(res);

    res = inputList.stream()
        .map(s -> Arrays.stream(s.split("")))
        .count();
    System.out.println(res);
  }
```

출력 결과는 10, 2가 나옵니다. 왜 이러한 결과가 나오는지 그림으로 다시 한 번 봅시다.

![map](https://github.com/hansojin/JAVA/assets/112622663/72285e1d-87ad-482b-bb65-3a107651f23a)

그림과 제 코드가 살짝 다르긴한데 상관은 없습니다. map은 매핑된 형태가 스트림이어도 되고 아니어도 무방하니까요. 위 사진에서 두 번째 줄을 보시면 알 수 있듯이, "Hello"가 5개의 요소로 쪼개지긴하는데 그 요소가 한꺼번에 스트림으로 묶여있습니다. 반면, 세 번째 줄을 보시면 알 수 있듯이, "Hello"가 5개의 단일 원소 스트림으로 쪼개집니다. 따라서 이 스트림 내의 존재한 메소드를 호출할 수 있습니다.

이것이 flatMapXXX()과 mapXXX()의 큰 차이점이라고 볼 수 있겠습니다.

지금까지는 flatMapXXX() 메소드와 mapXXX() 메소드의 차이를 중점적으로 설명하였고, 이번에는 mapXXX() 메소드를 사용하는 예제를 보겠습니다.

```
public static void main(String[] args) {
    List<Member> memberList = Arrays.asList(
        new Member("이산", Member.MALE, 22),
        new Member("진영", Member.MALE, 23),
        new Member("별찬", Member.MALE, 20)
    );

    memberList.stream()
        .mapToInt(Member::getAge)
        .forEach(System.out::println);
  }
```

Member 클래스의 멤버 변수로는 이름, 성별, 나이가 있는데, Member 객체의 나이를 출력하는 예제입니다. mapToInt() 메소드를 이용하여 Member를 int 매핑하는 것을 알 수 있습니다.

출력 결과는 22, 23, 20이 나옵니다.

3. asDoubleStream(), asLongStream(), boxed()

* asDoubleStream() 메소드는 IntStream의 int 요소 또는 LongStream의 long 요소를 double 요소로 타입 변환해서 DoubleStream을 생성합니다. 마찬가지로 asLongStream() 메소드는 IntStream의 int 요소를 long 요소로 타입 변환해서 LongStream을 생성합니다. boxed() 메소드는 int, long, double 요소를 Integer, Long, Double 요소로 박싱해서 Stream을 생성합니다. 여기서 주의할 점은 IntStream과 Stream<Integer>은 엄연히 다른 스트림이라는 것입니다.

```
 public static void main(String[] args) {
    int[] intArray = {1, 2, 3, 4, 5};

    IntStream intStream = Arrays.stream(intArray);
    intStream
        .asDoubleStream() 	// DoubleStream 생성
        .forEach(System.out::println);
    System.out.println();

    intStream = Arrays.stream(intArray);
    intStream
        .boxed() 			// Stream<Integer> 생성
        .forEach(obj -> System.out.println(obj.intValue()));
  }
```

asDoubleStream() 메소드와 boxed() 메소드를 사용한 간단한 예제입니다. 출력 결과는 다음과 같습니다.

// 1.0 2.0 3.0 4.0 5.0

// 1 2 3 4 5 

---

### 정렬

우리가 알고 있는 그 정렬이 맞습니다. 스트림은 중간 처리 단계에서 요소를 일정한 기준에 맞게 정렬을 할 수 있습니다. 정렬을 할 수 있는 스트림의 타입은 Stream<T>와 IntStream, DoubleStream, LongStream이 있는데, 이들을 나누어서 설명하겠습니다.

1. Stream<T>

* sorted()를 사용하였을 경우 객체를 Comparable 구현 방법에 따라 정렬합니다. Student 클래스가 있다고 하면, Comparable을 상속받아서 compareTo() 메소드를 오버라이드함으로써 정렬하는 기준을 정해줄 수 있습니다.
* 반면, sorted(Comparator<T>)를 사용하였을 경우 객체를 주어진 Comparator에 따라 정렬합니다. Comparator을 따로 정의하고 이를 객체로 생상형 sorted의 매개변수로 넘겨주어도 되고, Comparator의 내장된 메소드를 사용해도 되고, 람다식을 사용해도 무방합니다. 저는 개인적으로 "sorted( (a, b) -> a - b)"와 같이 람다식을 사용하는 편입니다.

```
public static void main(String[] args) {
    List<Member> memberList = Arrays.asList(
        new Member("이산", Member.MALE, 22),
        new Member("진영", Member.MALE, 23),
        new Member("별찬", Member.MALE, 20)
    );

    memberList.stream()
        .sorted((m1, m2) -> m1.getAge() - m2.getAge())
        .forEach(m -> System.out.println(m.getName()));
  }
```

Member의 나이를 기준으로 오름차순 정렬하였고, 정렬한 후 Member의 이름을 출력하는 예제입니다. 출력 결과는 "별찬, 이산, 진영"이 되겠습니다.

2. IntStream, DoubleStream, LongStream

* 이들은 sorted() 메소드를 사용하여 요소를 오름차순 정렬할 수 있습니다. 만약, 매개변수를 통하여 정렬하는 기준을 설정해 주고 싶다면, 위에서 설명한대로 Comparator를 정의하여 넣어주면 됩니다.











