### 쓰레드 풀 모델

* 쓰레드 생성과 소멸은 리소스 소모가 많은 작엄
* 쓰레드 풀은 쓰레드의 재활용을 위한 모델

```
class Lambda1 {
	public static void main(String[] args) {
		Runnable task = () -> {
			int n1 = 10, n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " +  (n1+n2));
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor();
		exr.submit(task);		//쓰레드 풀에 작업을 전달
		
		System.out.println("END " + Thread.currentThread().getName());
		exr.shutdown();		//쓰레드 풀과 그 안에 있는 쓰레드 소멸
		
		// 이전 모델은 쓰레드가 종료되면 자동 소멸 되고, 스레드 풀은 계속 대기 
		// 쓰레드 풀은 할당된 쓰레드가 모두 종료되면 소멸됨
		
	}
}	
// 실행 결과
>> End main
>> pool-1-thread-1 : 30
```

### 쓰레드 풀의 유형

* newSingleThreadExecutor
	* 풀 안에 하나의 쓰레드만 생성하고 유지
* newFixedThredPool(N)
	* 풀 안에 인자로 전달되는 수의 쓰레드를 생성하고 유지
* newCachedThreadPool
	* 풀 안의 쓰레드 수를 작업의 수에 맞게 유동적으로 관리
		* 실험적이라 확실히 좋다고는 말 할 수 없음
		
		
```
class Lambda3{
	public static void main(String[] args) {
		Runnable task1 = () -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : 1");
		};
		Runnable task2 = () -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : 2");
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(2);
		exr.submit(task1);		//쓰레드 풀에 작업을 전달
		exr.submit(task2);
		exr.submit(() -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + " : 3");
		});
		
		exr.shutdown();		//쓰레드 풀과 그 안에 있는 쓰레드 소멸
	}
}	

// 실행 결과
>> pool-1-thread-1 : 1
>> pool-1-thread-2 : 2
>> pool-1-thread-1 : 3
```
	
---

### Callable & Future

```
interface Runnable{
	void run();
};

@FunctionalInterface
interface Callable<V>{
	V call() throws Exception;
}
```
둘의 가장 큰 차이점은 반환형의 유무

Runnable 메소드는 반환형이 없고, Callable 메소드는 반환형을 지정할 수 있음

```
public static void main(String[] args) throws InterruptedException, ExecutionException{
	Callable<Integer> task = () -> {
		int sum=0;
		for(int i=0; i<10;i++)
			sum+=i;
		return sum;
	};
	ExecutorService exr = Executors.newSingleThreadExecutor();
	Future<Integer> fur = exr.submit(task);
	
	Integer r = fur.get();	//쓰레드의 반환값 획득 = 쓰레드가 완료된 후 반환값이 저장됨!
	System.out.println("result : " + r);
	exr.shutdown();
}
```


---

### 컬렉션 인스턴스 동기화

```
public static <T> Set<T> synchronizedSet(Set<T> s)
public static <T> List<T> synchronizedList(List<T> list)
public static <K,V> Map<K,V> synchronizedMap(Map<K,V> m)
public static <T> Collection<T> synchronizedCollection(Collection<T> c)

List<String> lst = Collections.synchronizedList(new ArrayList<String>());
```


