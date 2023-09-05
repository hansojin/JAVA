## 최종 처리 메소드 _ collect()

예제에서 사용할 사용자 정의 클래스를 미리 만들어 두겠습니다. 학생의 정보를 담는 클래스로, 아래 코드를 참고하시면 되겠습니다.

```
public class Student {

  public enum Sex {MALE, FEMALE}

  private String name;
  private int score;
  private Sex sex;

  public Student(String name, int score, Sex sex) {
    this.name = name;
    this.score = score;
    this.sex = sex;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public Sex getSex() {
    return sex;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object o) {
    Student s = (Student) o;
    return name.equals(s.getName());
  }
}
```

---

### 수집

스트림은 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 **collect() 메소드** 를 제공하고 있습니다. 이 메소드를 이용하면 **필요한 요소만 컬렉션으로 담을 수 있고, 요소들을 그룹핑한 후 집계할 수 있습니다.**

---

### 필터링한 요소 수집

1. 기본 컬렉션 (List, Set, ...)에 수집하기

스트림에서 collect() 메소드는 매개 변수에 따라 쓰임새가 달라지는데, 매개 변수를 Collector<T, A, R>을 취할 경우 주로 어떤 요소를 기본 컬렉션에 수집할 때 사용됩니다. Collector<T, A, R>에서 T는 요소이고, A는 누적기이며, R은 요소가 저장될 컬렉션입니다. 즉, T 요소를 A 누적기가 R에 저장한다는 의미죠.

아래는 Collectors 클래스의 정적 메소드입니다. 이를 이용하여 Collectior의 구현 객체를 얻어낼 수 있습니다.

| return type | Collectors' static method |Description |
| ----------- | ------------------------- |----------- |
|Collector<T, ?, List<T>>|	toList()|	T를 List에 저장|
|Collector<T, ?, Set<T>>|	toSet()|	T를 Set에 저장|
|Collector<T, ?, Collection<T>>|toCollection(Supplier<Collection<T>>)|T를 Supplier가 제공한 Collection에 저장|
|Collector<T, ?, Map<K, U>>|toMap(Function<T, K> keyMapper, Function<T, U> valueMapper)|T를 K와 U로 매핑해서 K를 키로, U를 값으로 Map에 저장|
|Collector<T, ?, ConcurrentMap<K, U>>|toConcurrentMap(Function<T, K> keyMapper, Function<T, U> valueMapper>|T를 K와 U로 매핑해서 K를 키로, U를 값으로 ConcurrentMap에 저장|

리턴값인 Collector를 보면 A(누적기)가 ?로 되어 있는데, 이것은 Collector가 R(컬렉션)에 T(요소)를 저장하는 방법을 알고 있어서 A가 필요 없기 때문입니다. 또한, Map과 ConcurrentMap의 차이점은 쓰레드의 안정성입니다. Map이 쓰레드에 안전하지 않고, ConcurrentMap이 쓰레드에 안전하기때문에 멀티쓰레드환경에서는 ConcurrentMap을 쓰는 것을 권장합니다.

아래는 전체 학생 중에서 남학생만 필터링해서 별도의 List를 생성하는 코드입니다.

```
public static void main(String[] args) {
    List<Student> studentList = Arrays.asList(
        new Student("이산", 10, Student.Sex.MALE),
        new Student("진영", 8, Student.Sex.MALE),
        new Student("민주", 11, Student.Sex.FEMALE),
        new Student("별찬", 10, Student.Sex.MALE)
    );

    List<Student> maleList = studentList.stream()
        .filter(s -> s.getSex() == Student.Sex.MALE)
        .collect(Collectors.toList());
  }
```

그리고 maleList에서 학생의 이름을 출력한다면, "이산", "진영", "별찬"이 출력될 것입니다.

같은 방식으로 Set 컬렉션도 얻어낼 수 있지만, HashSet 컬렉션을 얻고 싶다면 toCollection() 메소드를 작성해야합니다. 그리고 이 메소드의 매개변수로는 Supplier<Collection<T>>를 넘겨주면 됩니다.

아래는 전체 학생 중에서 여학생만 필터링해서 별도의 HashSet을 생성하는 코드입니다.

```
 HashSet<Student> femaleSet = studentList.stream()
        .filter(s -> s.getSex() == Student.Sex.FEMALE)
        .collect(Collectors.toCollection(HashSet::new));
  }
```

참고로 HashSet 내에서 이러한 객체가 같은지 비교하려면 hashCode() 메소드와 equals() 메소드를 오버라이드 해 주어야합니다. 

2. 사용자 정의 컨테이너에 수집하기

List, Set, Map과 같은 컬렉션이 아니라 사용자 정의 컨테이너 객체에 요소를 수집하는 방법에 대해 알아봅시다. 위에서는 매개변수로 Collector을 전달하는 collect() 메소드를 사용하였지만, 이번에는 총 3개의 매개변수를 필요로하는 collect() 메소드를 사용해야 합니다.

첫 번째로, Supplier<T>는 요소들이 수집될 컨테이너 객체(R)을 생성하는 역할을 합니다. 싱글 쓰레드 스트림에서는 단 한 번 Supplier가 실행되고 하나의 컨테이너 객체를 생성합니다. 반면, 멀티 쓰레드 스트림에서는 여러 번 Supplier가 실행되고 쓰레드 별로 여러 개의 컨테이너 객체를 생성합니다. 그리고 최종적으로 하나의 컨테이너 객체로 결합됩니다.

두 번째로, XXXConsumer는 컨테이너 객체(R)에 요소(T)를 수집하는 역할을 합니다. 스트림에서 요소를 컨테이너에 수집할 때마다 XXXConsumer가 실행됩니다.

마지막으로, BiConsumer는 컨테이너 객체(R)을 결합하는 역할을 하는데, 싱글 쓰레드 스트림에서는 호출되지 않고, 병렬 처리 스트림에서만 호출되어 쓰레드 별로 생성된 컨테이너 객체를 결합해서 최종 컨테이너 객체를 완성합니다.

리턴 타입 R은 요소들이 최종 수집된 컨테이너 객체를 의미합니다. 싱글 쓰레드 스트림에서는 리턴 객체가 첫 번째 Supplier가 생성한 객체지만, 병렬 처리 스트림에서는 최종 결합된 컨테이너 객체가 됩니다. 저는 이번 포스팅에서 싱글 쓰레드 스트림을 활용한 예제를 살펴보겠습니다.

이번 예제는 학생들 중에서 남학생만 수집하는 MaleStudent 컨테이너입니다. 이를 먼저 정의하겠습니다.

```
public class MaleStudent {

  private List<Student> list;

  public MaleStudent() {
    list = new ArrayList<>();
    System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent()");
  }

  // 요소를 수집
  public void accumulate(Student student) {
    list.add(student);
    System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
  }

  // 두 MaleStudent를 결합. (병렬 처리 시에만 호출)
  public void combine(MaleStudent other) {
    list.addAll(other.getList());
    System.out.println("[" + Thread.currentThread().getName() + "] combine()");
  }

  public List<Student> getList() {
    return list;
  }
  
}
```

아래는 main 메소드입니다.

```
public class Main {

  public static void main(String[] args) {
    List<Student> studentList = Arrays.asList(
        new Student("이산", 10, Student.Sex.MALE),
        new Student("진영", 8, Student.Sex.MALE),
        new Student("민주", 10, Student.Sex.FEMALE),
        new Student("별찬", 10, Student.Sex.MALE)
    );

//    Stream<Student> studentStream = studentList.stream();
//    Stream<Student> maleStream = studentStream.filter(s -> s.getSex() == Student.Sex.MALE);
//    Supplier<MaleStudent> supplier = MaleStudent::new;
//    BiConsumer<MaleStudent, Student> accumulator = MaleStudent::accumulate;
//    BiConsumer<MaleStudent, MaleStudent> combiner = MaleStudent::combine;
//    MaleStudent maleStudent = maleStream.collect(supplier, accumulator, combiner);

    MaleStudent maleStudent = studentList.stream()
        .filter(s -> s.getSex() == Student.Sex.MALE)
        .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);

    
    // HashSet을 Collector 없이 아래와 같이 표현이 가능함.
    HashSet<Student> femaleSet = studentList.stream()
        .filter(s -> s.getSex() == Student.Sex.FEMALE)
        .collect(HashSet::new, HashSet::add, HashSet::addAll);
  }
}
```

---

## 최종 처리 메소드 _ groupingBy()

이번에는 collect() 메소드를 이용하여 그룹핑하는 방법을 설명하겠습니다.

예제에서 사용할 사용자 정의 클래스를 미리 만들어 두겠습니다. 학생의 정보를 담는 클래스로, 아래 코드를 참고하시면 되겠습니다. 위에 사용한 학생 클래스에 도시 정보를 추가하고, 오버라이드된 메소드를 제거하였습니다.

```
public class Student {

  public enum Sex {MALE, FEMALE}

  public enum City {Seoul, Pusan}

  private String name;
  private int score;
  private Sex sex;
  private City city;

  public Student(String name, int score, Sex sex) {
    this.name = name;
    this.score = score;
    this.sex = sex;
  }

  public Student(String name, int score, Sex sex, City city) {
    this.name = name;
    this.score = score;
    this.sex = sex;
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public Sex getSex() {
    return sex;
  }

  public City getCity() {
    return city;
  }
}
```

---

### 요소를 그룹핑해서 수집

**collect()** 메소드는 **단순히 요소를 수집하는 기능 이외에 컬렉션의 요소들을 그룹핑해서 Map 객체를 생성하는 기능도 제공** 합니다. 여기서 collect()를 호출할 때 매개 변수로 **groupingBy() 또는 groupingByConcurrent() 메소드를 사용** 하면 됩니다. 전에 설명한 대로 전자는 쓰레드에 안전하지 않은 Map을 생성하지만, 후자는 쓰레드에 안전한 ConcurrentMap을 생성합니다.

![grouping](https://github.com/hansojin/JAVA/assets/112622663/b41c387c-e5f1-4f3d-9ee1-db7174062b21)

싱글 쓰레드만 내용을 다룰 것이기때문에 groupingByConcurrent() 메소드는 사용하지 않고, groupingBy() 메소드만 사용하겠습니다.

첫 번째는, 매개변수로 Function<T, K> classifier를 사용하는 groupingBy() 메소드입니다. 이 메소드의 리턴 타입을 보면, Collector<T, ?, Map<K, List<T>>>로, T를 K로 매핑한 후, 키가 K이면서 T를 저장하는 요소를 값으로 갖는 Map을 생성합니다.

두 번째는 매개변수로 Function<T, K> classifier, Collector<T, A, D> collector를 사용하는 groupingBy() 메소드입니다. 이 메소드의 리턴 타입을 보면, Collector<T, ?, Map<K, D>>로, T를 K로 매핑한 후, 키가 K이면서 키에 저장된 D객체에 T를 누적한 Map을 생성합니다.

세 번째는 두 번째의 매개 변수에서 Supplier가 추가된 형태입니다. 사용 방식도 위와 유사한데, 다만 그냥 Map이 아니라 TreeMap같은 Supplier가 제공하는 Map을 사용합니다.

```
 public static void main(String[] args) {
    List<Student> studentList = Arrays.asList(
        new Student("이산", 10, Student.Sex.MALE, Student.City.Seoul),
        new Student("진영", 8, Student.Sex.FEMALE, Student.City.Pusan),
        new Student("별찬", 9, Student.Sex.MALE, Student.City.Seoul),
        new Student("민주", 11, Student.Sex.FEMALE, Student.City.Pusan)
    );

    Map<Student.Sex, List<Student>> mapBySex = studentList.stream()
        .collect(Collectors.groupingBy(Student::getSex));

    System.out.print("[남학생] ");
    mapBySex.get(Student.Sex.MALE).forEach(s -> System.out.print(s.getName() + " "));

    System.out.print("\n[여학생] ");
    mapBySex.get(Student.Sex.FEMALE).forEach(s -> System.out.print(s.getName() + " "));
    System.out.println();
  }
```

위 예시 코드는 첫 번째 groupingBy() 메소드를 사용한 것이고, 학생의 성별을 기준으로 그룹핑하였습니다. groupingBy() 메소드의 매개변수로는 Function<T, K>를 사용하여 T를 K로 매핑하였습니다. 이때, T는 Student이고, K는 Student.Sex이므로 Map<Student.Sex(K), List<Student(T)>>이 생성되는 것입니다. 

다음 예시 코드를 살펴보겠습니다.

```
public static void main(String[] args) {
    List<Student> studentList = Arrays.asList(
        new Student("이산", 10, Student.Sex.MALE, Student.City.Seoul),
        new Student("진영", 8, Student.Sex.FEMALE, Student.City.Pusan),
        new Student("별찬", 9, Student.Sex.MALE, Student.City.Seoul),
        new Student("민주", 11, Student.Sex.FEMALE, Student.City.Pusan)
    );

    Map<Student.City, List<String>> mapByCity = studentList.stream()
        .collect(Collectors.groupingBy(
            Student::getCity,
            Collectors.mapping(Student::getName, Collectors.toList()))
        );

    System.out.print("[서울] ");
    mapByCity.get(Student.City.Seoul).forEach(s -> System.out.print(s + " "));

    System.out.print("\n[부산] ");
    mapByCity.get(Student.City.Pusan).forEach(s -> System.out.print(s + " "));
    System.out.println();
  }
```

위 예시 코드는 두 번째 groupingBy() 메소드를 사용한 것이고, 학생의 지역을 기준으로 그룹핑하였습니다. groupingBy() 메소드의 매개변수로는 Function<T, K>와 Collector<T, A, D> collector을 사용하였습니다. 여기서, mapByCity를 만드는 과정만 따로 자세히 살펴보겠습니다.

```
Function<Student, Student.City> classifier = Student::getCity;

Function<Student, String> mapper = Student::getName;

Collector<String, ?, List<String>> collector1 = Collectors.toList();

Collector<Student, ?, List<String>> collector2 = Collectors.mapping(mapper, collector1);

Collector<Student, ?, Map<Student.City, List<String>>> collector3 = Collectors
.groupingBy(classifier, collector2);

Map<Student.City, List<String>> mapByCity = studentList.stream().collect(collector3);
```

하나로 연결된 코드를 모두 분리해놨습니다. 먼저, Map의 Key를 얻어내기 위하여 T를 K로 매핑합니다. 여기서 T는 Student이며, K는 Student.City가 될 것이고, 이 과정은 첫 번째 줄에 해당합니다.

그리고 Map의 Value에 해당하는 D를 얻어야 하는데, 이 부분이 복잡합니다. 결과적으로, 우리는 Value가 List<Student>가 아니라, List<String>을 얻어야 합니다. 여기서 String은 학생의 이름이 되겠죠. 그래서 Student를 Student::getName으로 매핑하고, 이것을 다시 List<String>으로 매핑해야 합니다. 이 과정이 2 ~ 4번째 줄이 되겠습니다. 참고로, Collectors.mapping() 메소드는 아래에서도 다룰 예정이지만, T를 U로 매핑한 후, U를 R에 수집하는 역할을 합니다

여기까지 classifier와 collector을 모두 정의하였으므로 이 두 개를 매개 변수로 넘겨서 mapByCity를 형성하면 됩니다.

이제 세 번째 groupingBy() 메소드가 남았습니다. 이것은 위의 groupingBy() 메소드를 형성하는 원리와 거의 유사하나, Map의 형태를 구체화하여 저장할 수 있습니다.

```
TreeMap<Student.City, List<String>> treeMapByCity 
	= studentList.stream()
				.collect(Collectors.groupingBy(Student::getCity, TreeMap::new,
				Collectors.mapping(Student::getName, Collectors.toList())));
```

다음과 같이 Supplier가 들어갈 자리에 원하는 Map의 형태를 지정해 주는 것입니다.

---

### 그룹핑 후 매핑 및 집계

Collectors.groupingBy() 메소드는 그룹핑 후, 매핑이나 집계를 할 수 있도록 두 번째 매개값으로 Collector를 가질 수 있습니다. 위 예제에서 매개 변수가 하나만 있는 groupingBy() 메소드도 있었지만, 2개 또는 3개가 있는 groupingBy() 메소드를 다뤘습니다. 이 중, 2개 또는 3개의 매개 변수를 갖는 groupingBy() 메소드가 그룹핑 후 매핑 및 집계를 사용합니다. 위 예제에서는 mapping() 메소드를 활용하였지만, 집계를 통해서 Value 값을 무궁무진하게 변화시킬 수 있습니다.

```
public static void main(String[] args) {
    List<Student> studentList = Arrays.asList(
        new Student("이산", 10, Student.Sex.MALE, Student.City.Seoul),
        new Student("진영", 8, Student.Sex.FEMALE, Student.City.Pusan),
        new Student("별찬", 9, Student.Sex.MALE, Student.City.Seoul),
        new Student("민주", 11, Student.Sex.FEMALE, Student.City.Pusan)
    );

    Map<Student.Sex, Double> mapBySex = studentList.stream()
        .collect(
            Collectors.groupingBy(
                Student::getSex,
                Collectors.averagingDouble(Student::getScore)
            )
        );

    System.out.println("남학생 평균 점수 : " + mapBySex.get(Student.Sex.MALE));
    System.out.println("여학생 평균 점수 : " + mapBySex.get(Student.Sex.FEMALE));
  }

```

위 코드는 성별을 기준으로 평균 점수를 저장하는 맵을 생성합니다

Map의 Key는 첫 번째 줄을 통하여 얻어낼 수 있고, Value는 두, 세 번째 줄을 통하여 얻어낼 수 있습니다. 특히, Value는 Student를 Double로 매핑한다는 점을 주의 깊게 보셔야 합니다.

출력 결과는 남자와 여자 모두 9.5가 나올 것입니다. 다음 예제를 보겠습니다

```
 public static void main(String[] args) {
    List<Student> studentList = Arrays.asList(
        new Student("이산", 10, Student.Sex.MALE, Student.City.Seoul),
        new Student("진영", 8, Student.Sex.FEMALE, Student.City.Pusan),
        new Student("별찬", 9, Student.Sex.MALE, Student.City.Seoul),
        new Student("민주", 11, Student.Sex.FEMALE, Student.City.Pusan)
    );

    Map<Student.Sex, String> mapByName = studentList.stream()
        .collect(
            Collectors.groupingBy(
                Student::getSex,
                Collectors.mapping(
                    Student::getName,
                    Collectors.joining(", ")
                )
            )
        );

    System.out.println("남학생 전체 이름 : " + mapByName.get(Student.Sex.MALE));
    System.out.println("여학생 전체 이름 : " + mapByName.get(Student.Sex.FEMALE));
  }
```

이 예제는 학생들을 성별로 그룹핑한 다음 같은 그룹에 속하는 학생 이름을 쉼표로 구분해서 문자열을 만들고, 성별을 Key로, 문자열을 Value로 갖는 Map을 생성합니다.

mapping() 메소드를 통하여 Student를 String으로 매핑합니다. 'Student -> String(구분자 없음) -> String(구분자 있음)'으로 매핑된다는 사실을 기억하셔야하고, 구분자는 맨 마지막에는 첨가되지 않는다는 것에 유의하셔야합니다.


