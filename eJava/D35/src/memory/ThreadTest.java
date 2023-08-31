package memory;

class ShowThread extends Thread{
	String threadName;
	
	public ShowThread(String threadName){
		this.threadName = threadName;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println(threadName);
			try {
				sleep(100);		//0.1sec
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// 해당 클래스에는 3개 thread가 돌아감 _ main thread까지 포함
class ThreadTest {
	public static void main(String[] args) {
		ShowThread th1 = new ShowThread("A");
		ShowThread th2 = new ShowThread("B");
		th1.start();	
		th2.start();
		
		/*
		Java에는 콜 스택이 있다. 
		콜 스택은 실질적인 명령어들을 담고 있는 메모리로, 하나씩 꺼내서 실행시키는 역할을 하게 된다. 
		따라서 만약 동시에 두 가지 작업을 수행한다면 콜스택이 두개가 필요하다! 
		스레드를 여러개 이용한다는 것은 JVM이 다수의 콜 스택을 번갈아가며 처리하고 동시에 동작하는 것처럼 눈속임을 하는 것이다. 
		
		run() 호출은 콜 스택을 생성하지 않는다.
		run() 호출을 하여 스레드를 동작시키게 된다면 콜 스택이 생성되지 않고 main()의 콜 스택을 공유하게 된다!  
		run() 호출을 하여 스레드를 동작시키는 것은 스레드의 장점을 살릴 수 없는 것이다. 
		반면에 start()를 호출하게 되면, JVM는 알아서 콜 스택을 새로 만들어주고 
		context switching을 통해 동시에 동작하는 것처럼 보이게 한다.
		
		결론은 start()를 호출하면 내부적으로 콜 스택을 생성하고 run()을 자동적으로 호출한다
		*/
	}
}
