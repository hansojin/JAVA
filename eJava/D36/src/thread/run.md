1. **extends Thread** 를 통한 스레드 구현

```
public class ExtendsThread extends Thread {
	
	public void run() {
		System.out.println("ExtendsThread Start");
	}

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread(); // 객체화
		et.start(); // start()시 run() 메소드 사용
	}

}
```

2.  **implements Runnable** 을 통한 스레드 구현

```
public class ImpleThread implements Runnable {

	public void run() {
		System.out.println("ImpleThread Start");
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new ImpleThread()); // Thread 
		thread.start();
	}

}
```

---

* extends Thread를 사용하는 경우에는, Thread를 상속받고 객체화한 뒤에 객체명.start()를 통해 사용하고

* implements Runnable을 사용하는 경우에는, Thread 객체 안에 쓰레드를 사용하려는 객체를 넣어줘서 객체화한 뒤 사용한다


보면 extends Thread 쪽이 길이가 더 짧아서 나아보일 수 있는데

extends의 경우에는 하나밖에 상속을 받지 못하는 만큼 클래스명 extends A,B 이렇게 사용을 못한다

반면 implements는 implements a,b 가 가능하기 때문에

**뭔가 상속받아야 할 게 있다면 implements Runnable을 사용하면 되고, 딱히 상속받을게 없다면 extends Thread를 사용해주면 된다**
