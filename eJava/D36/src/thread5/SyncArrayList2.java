package thread5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SyncArrayList2 {
	
    public static List<Integer> lst = Collections.synchronizedList(new ArrayList<Integer>());

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 16; i++)
            lst.add(i);
        System.out.println("before : " + lst);

//        Runnable task = () -> {
//            ListIterator<Integer> itr = lst.listIterator();
//                
//            while(itr.hasNext())
//                itr.set(itr.next() + 1);
//        };
        
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
        System.out.println("after  : " + lst);
    }
}

/*
따라서 반복자를 통해 접근 할 때에는, 다음과 같이 이에 대한 동기화도 추가해야 한다.

Runnable task = () -> {
	synchronized(lst){			//	이 영역 실행 시 lst에 다른 쓰레드 접근 불가!
		ListIterator<Integer> itr = lst.listIterator();
		while(itr.hasNext())
			itr.set(itr.next()+1);
	}
}

위의 코드에서 동기화 블록이 갖는 의미는 다음과 같다.

"동기화 블록의 내부를 실행할 때 lst에 다른 쓰레드의 접근을 허용하지 않는다."

앞서 synchronized를 대신할 수 있는 ReentrantLock 기반의 동기화 방법을 소개했는데, 그렇다고
해서 키워드 synchronized가 불필요해진 것은 아니다. 그리고 지금까지 ArrayList<E>를 기반으로
동기화를 설명했지만, 다른 컬렉션 인스컨스의 동기화 방법도 이와 동일하다.

[참고] 동기화 처리가 된 Vector 클래스

컬렉션 프레임워크의 Vector 클래스는 기본적으로 동기화가 되어있다. 따라서 동기화가 불필요한 상황에서
사용하면 아무런 의미 없이 성능만 저하가 된다. 그래서 이를 대신하기 위해 자바 2에서는 동기화 처리가
되어 있지 않은 ArrayList와 LinkedList를 추가하였다.
*/
