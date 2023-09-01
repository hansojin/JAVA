앞서 보인 방식에 비교해서 새로운 동기화 방식을 소개하고자 한다. 자바는 java.util.concurrent 패키지를 통해서 보다 다양한 형태의 동기화 방식을 지원하기 시작했다.

* synchronized 키워드의 대체

자바 버전 5.0에서는 동기화 블록, 또는 동기화 메소드를 대신해서 사용할 수 있는 **ReentrantLock** 이라는 이름의 클래스를 제공하기 시작했는데, 이를 적용하기 위한 기본적인 구조는 다음과 같다.

```
class MyClass{
	private final ReentrantLock criticObj = new ReentrantLock();
	...
	void myMethod(int arg){
		criticObj.lock();		// 다른 쓰레드가 진입하지 못하게 문을 잠근다.
		...
		...
		criticObj.unlock();	// 다른 쓰레드의 진입이 가능하게 문을 연다.
	}
}
```

위 코드에서 보면, ReentrantLock의 인스턴스를 이용해서 **lock 메소드와 unlock 메소드를 호출** 하고 있다. 

여기서 lock 메소드는 한번 호출되면, unlock 메소드가 호출될 때까지 lock 메소드의 재호출이 불가능하기 때문에, lock 메소드가 호출되는 시점부터 unlock 메소드가 호출되는 시점까지, 둘 이상의 쓰레드에 의해서 동시에 실행되지 않는 영역이 된다. 그런데 만약에 lock 메소드를 호출한 쓰레드가 unlock 메소드를 호출하지 않으면, 이는 큰 문제가 될 수 있기 때문에 다음과 같이 코드를 작성하는 것이 보다 안정적이다.

```
class MyClass{
	private final ReentrantLock criticObj=new ReentrantLock();
	...
	void myMethod(int arg){
		criticObj.lock();			// 다른 쓰레드가 진입하지 못하게 문을 잠근다.
		try{
			...
		}
		finally{
			criticObj.unlock();	// 다른 쓰레드의 진입이 가능하게 문을 연다.
		}
	}
}
```

위와 같이 unlock 메소드의 호출을 finally 구문에 묶어두면, 어느 상황에서건 unlock 메소드의 호출을 보장받을 수 있다. 

따라서 둘 이상의 쓰레드가 동시에 실행하면 안 되는 코드를 try 구문에 넣어두고, unlock 메소드의 호출을 finally 구문에 넣어서 코드의 안전성을 높이는 것이 좋다.

15. IHaveTwoNum 소스를 ReentrantLock을 이용하여 수정하시오.

```
import java.util.concurrent.locks.ReentrantLock;

class IHaveTwoNum{
	int num1=0;
	int num2=0;
	
	public void addOneNum1() {
		key1.lock();
		try{
			num1+=1;
		}
		finally{
			key1.unlock();
		}
	}
	public void addTwoNum1() { 
		key1.lock();
		try{
			num1+=2;
		}
		finally{
			key1.unlock();
		}
	}	
	public void addOneNum2() { 
		key2.lock();
		try{
			num2+=1;
		}
		finally{
			key2.unlock();
		}
	}
	public void addTwoNum2() { 
		key2.lock();
		try{
			num2+=2;
		}
		finally{
			key2.unlock();
		}
	}
	
	public void showAllNums(){
		System.out.println("num1: "+num1);
		System.out.println("num2: "+num2);
	}
	
	private final ReentrantLock key1=new ReentrantLock();
	private final ReentrantLock key2=new ReentrantLock();
}

class AccessThread extends Thread{
	IHaveTwoNum twoNumInst;
	
	public AccessThread(IHaveTwoNum inst){
		twoNumInst=inst;
	}
	
	public void run(){
		twoNumInst.addOneNum1();
		twoNumInst.addTwoNum1();
		
		twoNumInst.addOneNum2();
		twoNumInst.addTwoNum2();
	}
}

class UseReentrantLock{
	public static void main(String[] args){
		IHaveTwoNum numInst=new IHaveTwoNum();
		
		AccessThread at1=new AccessThread(numInst);
		AccessThread at2=new AccessThread(numInst);
		
		at1.start();
		at2.start();
		
		try{
			at1.join();
			at2.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		numInst.showAllNums();
	}
}
```

* lock 메소드는 한번 호출되면, unlock 메소드가 호출될 때까지 재호출이 불가능하기 때문에, lock 메소드가 호출되는 시점부터 unlock 메소드가 호출되는 시점까지, 둘 이상의 쓰레드에 의해서 동시에 실행되지 않는 영역이 된다.

16. ReentrantLock 인스턴스를 대상으로 **newCondition** 이라는 이름의 메소드를 호출하면, **Condition형 인스턴스가 반환** 된다(정확히는 Condition 인터페이스를 구현하는 인스턴스의 참조 값이 반환된다). 그리고 반환된 인스턴스를 대상으로 다음의 메소드를 호출할 수 있다.

* **await**		낮잠을 취한다.(wait 메소드에 대응)
* **signal**		낮잠 자는 쓰레드 하나를 깨운다(notify 메소드에 대응)
* **signalAll**	낮잠 자는 모든 쓰레드를 깨운다(notifyAll 메소드에 대응)

이 메소드들 역시 한번에 하나의 메소드만 호출될 수 있도록 동기화 처리가 되어야 한다. 단 반드시 앞서보인 ReentrantLock 인스턴스 기반으로 동기화 처리가 되어야 한다(synchronized 기반이 아닌).

17. 예제를 통해서 Condition 인스턴스 기반의 실행순서 동기화의 사례를 보여라. 이 예제에서는 두 개의 쓰레드가 생성되는데, 하나는 프로그램 사용자로부터 문자열을 입력 받는 쓰레드이고, 다른 하나는 입력 받은 문자열을 출력하는 쓰레드이다.

```
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.Scanner;

class StringComm{
	String newString;
	boolean isNewString=false;
	
	private final ReentrantLock entLock=new ReentrantLock();
	private final Condition readCond=entLock.newCondition();
	private final Condition writeCond=entLock.newCondition();
	
	public void setNewString(String news){
		entLock.lock();
		try{
			if(isNewString==true)
				writeCond.await();
				
			newString=news;
			isNewString=true;
			readCond.signal();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		finally{
			entLock.unlock();
		}
	}
	
	public String getNewString(){
		String retStr=null;
		
		entLock.lock();
		try{
			if(isNewString==false)
				readCond.await();
			
			retStr=newString;
			isNewString=false;		
			writeCond.signal();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}		
		finally{
			entLock.unlock();
		}
			
		return retStr;
	}
}

class StringReader extends Thread{
	StringComm comm;
	
	public StringReader(StringComm comm){
		this.comm=comm;
	}
	public void run(){
		Scanner keyboard=new Scanner(System.in);
		String readStr;
		
		for(int i=0; i<5; i++){
			readStr=keyboard.nextLine();
			comm.setNewString(readStr);
		}
	}
}

class StringWriter extends Thread{
	StringComm comm;
	
	public StringWriter(StringComm comm){
		this.comm=comm;
	}
	public void run(){
		for(int i=0; i<5; i++)
			System.out.println("read string: "+comm.getNewString());
	}
}

class ConditionSyncStringReadWrite{
	public static void main(String[] args){
		StringComm strComm=new StringComm();
		StringReader sr=new StringReader(strComm);
		StringWriter sw=new StringWriter(strComm);
	
		System.out.println("입출력 쓰레드의 실행...");
		sr.start();
		sw.start();
	}
}
```