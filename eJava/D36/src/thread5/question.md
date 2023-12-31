1. main 쓰레드의 이름을 출력해 보자.

```
class CurrentThreadName {
    public static void main(String[] args) {
        Thread ct = Thread.currentThread();
        String name = ct.getName();
        System.out.println(name);
    }
}
```
2. 실행 결과가 "0 2 4 6 8 10 12 14 16 18 "와 같이 나오도록 람다를 완성하자.

```
class MakeThreadMultiDemo {
    public static void main(String[] args) {
        Runnable task1 = () -> {   
                for(int i = 0; i < 20; i++) {
                    if(i % 2 == 0)
                        System.out.print(i + " ");
                }
        };
        Thread t1 = new Thread(task1);
        t1.start();
    }
}
```

3. 다음 task를 쓰레드풀을 생성한 후에 그 쓰레드풀을 이용해서 실행하자. 그리고 쓰레드 풀을 소멸하도록 하자.

```
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class ExecutorsDemo {
    public static void main(String[] args) {
        Runnable task = () -> {     // 쓰레드에게 시킬 작업
            int n1 = 10;
            int n2 = 20;
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + (n1 + n2));
        };
        
        ExecutorService exr = Executors.newSingleThreadExecutor();
        exr.submit(task);    // 쓰레드 풀에 작업을 전달

        System.out.println("End " + Thread.currentThread().getName());

        exr.shutdown();    // 쓰레드 풀과 그 안에 있는 쓰레드의 소멸
    }
}
```

4.  쓰레드풀을 만들고, Callable<V> 인터페이스를 기반으로 1부터 10까지 더한 값을 반환 받도록 코드를 작성하자.

```
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;

class CallableDemo {
    public static void main(String[] args) 
              throws InterruptedException, ExecutionException {
        Callable<Integer> task = () -> {
            int sum = 0;
            for(int i = 0; i < 10; i++)
                sum += i;
            return sum;
        };
        
        ExecutorService exr = Executors.newSingleThreadExecutor();
        Future<Integer> fur = exr.submit(task);
        
        Integer r = fur.get();
        System.out.println("result: " + r);
        exr.shutdown();
    }
}
```

5. ArrayList의 동기화 처리 예시를 작성하자.

```
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class SyncArrayList {
    public static List<Integer> lst = 
              Collections.synchronizedList(new ArrayList<Integer>());

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 16; i++)
            lst.add(i);
        System.out.println(lst);

        Runnable task = () -> {
            synchronized(lst) {
                ListIterator<Integer> itr = lst.listIterator();
                
                while(itr.hasNext())
                    itr.set(itr.next() + 1); 
            }
        };

        ExecutorService exr = Executors.newFixedThreadPool(3);
        exr.submit(task);
        exr.submit(task);
        exr.submit(task);
     
        exr.shutdown();
        exr.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println(lst);
    }
}
```