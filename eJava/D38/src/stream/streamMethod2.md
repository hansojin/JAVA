## 최종 처리 메소드의 종류

![final](https://github.com/hansojin/JAVA/assets/112622663/5741a60e-64b8-40ef-b597-ce13eea67211)

**중간 처리 메소드의 리턴 타입은 스트림이었던 반면에, 최종 처리 메소드는 기본 타입이거나 OptionalXXX입니다.** 또한, 소속된 인터페이스가 공통이라는 의미는 Stream, IntStream, LongStream, DoubleStream에서 모두 제공된다는 뜻입니다.

---

### 루핑

루핑은 특이하게도 중간 처리 메소드에서도 사용되고, 최종 처리 메소드에서도 사용됩니다. 그렇다면, 이 둘의 차이는 무엇일까요?

기능 자체는 루핑한다는 것에서 동일하지만, peek() 최종 처리 메소드가 없으면 동작하지않습니다. forEach() 메소드는 그 자체로 최종 처리 메소드이기때문에 루핑이 정상적으로 작동합니다.

```
public static void main(String[] args) {
    int[] intArr = {1, 2, 3, 4, 5};

    System.out.println("[peek()를 마지막에 호출한 경우]");
    Arrays.stream(intArr)
        .filter(a -> a % 2 == 0)
        .peek(System.out::println); // 동작하지 않음.

    System.out.println("[최종 처리 메소드를 마지막에 호출한 경우]");
    int total = Arrays.stream(intArr)
        .filter(a -> a % 2 == 0)
        .peek(System.out::println) // 동작함.	2 4 출력
        .sum(); // 요소의 합을 구하는 최종 처리 메소드
    System.out.println("총합 : " + total);	// 6

    System.out.println("[forEach()를 마지막에 호출한 경우");
    Arrays.stream(intArr)
        .filter(a -> a % 2 == 0)
        .forEach(System.out::println);	// 2 4
  }
```

최종 처리 메소드없이 peek()만 호출하면 그 안에 있는 짝수 요소가 출력되지 않으며, 최종 처리 메소드가 존재할 때 peek()을 호출하면 짝수 요소가 출력된다는 사실을 알 수 있습니다. 또한, forEach()는 그 자체로 최종 처리 메소드이므로 마지막에 사용함으로써 짝수 요소를 출력하게 만들 수 있습니다.

---

### 매칭

매칭은 **최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사할 수 있도록 설계한 것** 입니다. 비슷한 역할로는 중간 처리 단계에서 필터링이 있겠네요.

**리턴 타입은 모두 boolean** 이고, 메소드는 allMatch(), anyMatch(), noneMatch()가 있습니다. 그리고 이 메소드들의 매개 변수는 Predicate를 사용합니다. 제공 인터페이스가 Stream일 경우에는 Predicate<T>지만, 나머지에 대해서는 IntPredicate 또는 LongPredicate 또는 DoublePredicate입니다.

```
public static void main(String[] args) {
    int[] intArr = {2, 4, 6};

    boolean result = Arrays.stream(intArr)
        .allMatch(a -> a % 2 == 0);
    System.out.println("모두 2의 배수인가? : " + result);	//true

    result = Arrays.stream(intArr)
        .anyMatch(a -> a % 3 == 0);
    System.out.println("하나라도 3의 배수가 있는가? : " + result);	//true

    result = Arrays.stream(intArr)
        .noneMatch(a -> a % 3 == 0);
    System.out.println("3의 배수가 없는가? : " + result);	//false
  }
```

--- 

### 기본 집계

집계는 최종 처리 기능으로 요소들을 처리해서 카운팅, 합계, 평균값, 최댓값, 최솟값 등과 같이 하나의 값으로 산출하는 것을 말합니다.

![end](https://github.com/hansojin/JAVA/assets/112622663/5cad5851-94b8-4370-9f84-517d4c05af57)

위와 같이 count()와 sum()을 제외하면 **리턴 타입이 Optional** 이라는 것을 알 수 있습니다. OptionalXXX는 자바 8에서 추가한 java.util 패키지의 새로운 클래스 타입으로, **값을 저장하는 값 기반 클래스** 들입니다. 이 **객체에서 값을 얻기 위해서는 get(), getAsDouble(), getAsInt(), getAsLong()을 호출** 하면 됩니다.

```
public static void main(String[] args) {
    long count = Arrays.stream(new int[]{1, 2, 3, 4})
        .filter(n -> n % 2 == 0)
        .count();
    System.out.println("2의 배수의 개수 : " + count);

    long sum = Arrays.stream(new int[]{1, 2, 3, 4})
        .filter(n -> n % 2 == 0)
        .sum();
    System.out.println("2의 배수의 합 : " + sum);

    double avg = Arrays.stream(new int[]{1, 2, 3, 4})
        .filter(n -> n % 2 == 0)
        .average()
        .getAsDouble();
    System.out.println("2의 배수의 평균 : " + avg);

    int max = Arrays.stream(new int[]{1, 2, 3, 4})
        .max()
        .getAsInt();
    System.out.println("최댓값 : " + max);

    int min = Arrays.stream(new int[]{1, 2, 3, 4})
        .min()
        .getAsInt();
    System.out.println("최솟값 : " + min);

    int first = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
        .filter(n -> n % 3 == 0)
        .findFirst()
        .getAsInt();
    System.out.println("첫 번째 3의 배수 : " + first);
  }
```

---

### Optional 클래스

기본 집계에서 이어지는 내용입니다. Optional 클래스는 위에서 값을 저장하는 값 기반 클래스라고 하였는데, 사실 값만 저장하는 것이 아니라, 집계 값이 존재하지 않을 경우 디폴트 값을 설정할 수 있고, 집계 값을 처리하는 Consumer도 등록할 수 있습니다.

아래는 Optional 클래스에서 제공하는 메소드 목록입니다.

![optional](https://github.com/hansojin/JAVA/assets/112622663/9f0f8cd9-d049-43a4-905c-50238695111b)

값이 저장되어 있는지 여부가 필요한 경우는 많습니다. 컬렉션의 요소는 동적으로 추가되는 경우가 많은데, 만약 컬렉션의 요소가 추가되지 않아 저장된 요소가 없을 경우, 평균값을 구하거나 합을 구하는 작업을 수행할 수 없습니다. 요소가 하나도 없기 때문이죠.

이러한 예외(NoSuchElementException)를 막기 위한 방법은 총 3가지가 있습니다. 이해를 돕기 위하여 아래 코드와 같은 상황을 하나 설정하겠습니다.

```
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    // list에 요소가 없을 경우 NoSuchElementException 발생!
    double avg = list.stream()
        .mapToInt(Integer::intValue)
        .average()
        .getAsDouble();
  }
```

1.  Optional 객체를 얻어서 isPresent() 메소드 사용
	* isPresent() 메소드는 값이 저장되어 있는지 확인하는 메소드로, 가장 기본적으로 if문을 활용하여 작성하면 됩니다.

```
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    OptionalDouble optional = list.stream()
        .mapToInt(Integer::intValue)
        .average();

    if (optional.isPresent()) {
      System.out.println("평균 : " + optional.getAsDouble());
    } else {
      System.out.println("평균 : 0.0");
    }
  }
```

2. orElse() 메소드로 디폴트 값 설정
	* orElse() 메소드는 값이 저장되어 있지 않을 경우 디폴트 값을 지정하는 역할을 합니다. 참고로 orElse() 메소드를 사용할 경우, 디폴트 값을 지정하는 동시에 값을 반환합니다. getXXX() 메소드를 쓸 필요가 없는 것이죠.
	
```
ublic static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    double avg = list.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElse(0.0);
    System.out.println("평균 : " + avg);
  }
```

3. ifPresent() 메소드 사용
	* ifPresent() 메소드는 값이 저장되어 있을 경우 Consumer에서 연산을 수행하도록 합니다. 이때, Consumer 안에서 람다식으로 하고자 하는 작업을 표현할 수 있습니다.
	
```
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.stream()
        .mapToInt(Integer::intValue)
        .average()
        .ifPresent(a -> System.out.println("평균 : " + a));
  }
```

---

### 커스텀 집계

스트림은 기본 집계말고도 reduce() 메소드라는 커스텀 집계를 제공합니다. 직접 기준을 세워서 집계를 하는 것이죠.

![custom](https://github.com/hansojin/JAVA/assets/112622663/0cbcfef6-f740-4601-ade1-7b5fd65c2b9f)

사용하는 인터페이스는 Stream, IntStreaem, LongStream, DoubleStream이 있고, 리턴 타입은 Optional 혹은 T로 되어 있습니다. Optional과 T로 리턴되는 기준은 바로 메소드의 매개변수 중 identity의 유무입니다.

identity 매개값은 쉽게 말해서 디폴트값이라고 보면 됩니다. 자세한 reduce() 메소드의 동작 과정은 소스코드를 통해 살펴 봅시다.

```
 public static void main(String[] args) {
    List<Member> memberList = Arrays.asList(
        new Member("이산", Member.MALE, 23),
        new Member("진영", Member.MALE, 22),
        new Member("별찬", Member.MALE, 21)
    );

    int sum = memberList.stream()
        .map(Member::getAge)
        .reduce(Integer::sum) // 스트림의 요소를 누적해서 더해 나감.
        .orElse(0); // 디폴트값 설정하지 않으면 NoSuchElementException 발생!
    System.out.println(sum);

    sum = memberList.stream()
        .map(Member::getAge)
        .reduce(0, Integer::sum); // 디폴트값을 0으로 설정하고, 스트림의 요소를 누적해서 더해 나감.
    System.out.println(sum);
  }
```

전자는 identity 매개값을 설정하지 않은 것이고, 후자는 설정한 것입니다. 그리고 전자는 위의 Optional 클래스에서 설명한대로 디폴트값에 대한 예외 처리를 해 주어야 합니다. 반면, 후자는 이미 reduce() 메소드에서 디폴트값을 설정해 주었기때문에 리스트이 요소가 없어도 예외가 발생하지 않습니다.

reduce는 기본적으로 스트림의 요소를 하나씩 방문하면서 개발자가 정한 기준에 따라서 누적 연산을 합니다. 위 예제 코드에서는 덧셈 연산으로 설정하였기때문에 멤버의 나이를 누적 덧셈을 하게 됩니다.

출력 결과는 둘다 66이 나오게 됩니다.










