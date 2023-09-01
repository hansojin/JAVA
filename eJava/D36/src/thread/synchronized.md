6. Increment라 이름의 num이라는 인스턴스 변수를  가진 클래스가 있고 그 클래스는 1씩 증가시키는 메소드와 숫자 값을 가져오는 메소드가 있다. IncThread라는 클래스는 Increment라는 클래스의 참조변수를 인스턴스변수로 가지고 있고 쓰레드를 실행시키면 중첩된 반복문으로 각각 10000 씩 Increment의 1씩 증가시키는 메소드를 호출한다. 그리고 main메소드가 있는 클래스에서 Increment 인스턴스한개 IncThread 3개를 만들고 3개의 쓰레드를 실행한 후에 Increment의 num의 값을 출력해본다.

```
class Increment{
	int num=0;
	public void increment(){ num++; }
	public int getNum() { return num; }
}

class IncThread extends Thread{	
	Increment inc;
	
	public IncThread(Increment inc){
		this.inc=inc;
	}
	public void run(){
		for(int i=0; i<10000; i++)
			for(int j=0; j<10000; j++)
				inc.increment();
	}
}

class ThreadSyncError{
	public static void main(String[] args){
		Increment inc=new Increment();
		IncThread it1=new IncThread(inc);
		IncThread it2=new IncThread(inc);
		IncThread it3=new IncThread(inc);
		
		it1.start();
		it2.start();
		it3.start();
		
		try{
			it1.join();
			it2.join();
			it3.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(inc.getNum());
	}
}
```

7. 6번 문제는 동기화가 제대로 되지 않아 잘못된 값을 출력할 확률이 높다. 이 것을 동기화 시키는 두 가지 방법으로 동기화가 제대로 이루어 지도록 하자.

1. **동기화 메소드** 선언

```
public synchronized void increment(){
	num++;
}
```

2. **동기화 블록** 지정	// 이게 더 효율적임. 해당 작업 중에만, 동기화시키면 되니까

```
public void increment(){
	synchronized(this){
		num++;
	}
}
```

쓰레드의 동기화로 인하여 성능이 매우 많이 저하된다. 따라서 동기화가 필요한 것은 사실이지만, 필요한 위치에 제한적으로 사용해서 성능에 영향을 주지 않도록 주의해야 한다.

```
public synchronized int add(...){
	...
}
public synchronized int min(...){
	...
}
public void showOpCnt(){
	...
}
```

자바의 모든 인스턴스에는 하나의 열쇠가 존재한다(비록 눈에 보이지는 않지만). 전문용어로 이 열쇠를 가리켜 lock 또는 monitor라 하는데, 이를 그냥 '열쇠'로 이해해도 된다(이는 운영체제라는 과목의 전통적인 이해방식이다.) 그리고 synchronized 선언된 메소드에는 자물쇠가 걸린다. 따라서 synchronized로 선언된 메소드를 호출하려면 먼저 열쇠를 획득해야 한다. 그리고는 열쇠로 자물쇠를 열고 들어가야 한다. 그런데  위에 코드에서 열쇠는 하나다. 따라서 인스턴스 내에서 **synchronized로 선언된 모든 메소드는 동시에 둘 이상이 실행될 수 없다.**

물론 여러분은 열쇠의 획득과 반납을 코드상에 명시할 필요는 없다. synchronized로 선언된 메소드를 호출하면 열쇠는 자동으로 획득이 되고, 메소드를 빠져나오면 획득한 열쇠는 자동으로 반납이 되기 때문이다.(참고로 이것이 synchrozied 선언의 매력이다. 실수로 열쇠를 반납하지 않는 문제가 발생하지 않기 때문이다.) 물론 자물쇠가 걸려있지 않은(synchronized로 선언되지 않은) 메소드의 호출은 제한을 받지 않는다.

동기화의 대상이 인스턴스이긴 하지만 동기화의 대상이 인스턴스라고 표현을 하다 보니, synchronized로 선언된 메소드가 호출이 되면, 호출된 인스턴스에는 다른 쓰레드의 접근이 아예 불가능한 것으로 오해하는 경우가 많다. 하지만 synchronized로 선언되지 않은 메소드에는 얼마든지 접근이 가능하다.

8. 문제 8 폴더에 있는 SyncObjectKy를 적절하게 Key를 사용하여 동기화해보자.(두 가지 방법)

```
class IHaveTwoNum{
	int num1=0;
	int num2=0;
	
	public void addOneNum1() {
		synchronized(key1){
			num1+=1; 
		}
	}
	public void addTwoNum1() { 
		synchronized(key1){
			num1+=2; 
		}
	}	
	public void addOneNum2() { 
		synchronized(key2){
			num2+=1; 
		}
	}
	public void addTwoNum2() { 
		synchronized(key2){
			num2+=2; 
		}
	}
	
	public void showAllNums(){
		System.out.println("num1: "+num1);
		System.out.println("num2: "+num2);
	}
	
	Object key1=new Object();
	Object key2=new Object();
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

class SyncObjectKeyAnswer{
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

```
class IHaveTwoNum{
	int num1=0;
	int num2=0;
	
	public void addOneNum1() {
		synchronized(this){
			num1+=1; 
		}
	}
	public void addTwoNum1() { 
		synchronized(this){
			num1+=2; 
		}
	}	
	public void addOneNum2() { 
		synchronized(key1){
			num2+=1; 
		}
	}
	public void addTwoNum2() { 
		synchronized(key1){
			num2+=2; 
		}
	}
	
	public void showAllNums(){
		System.out.println("num1: "+num1);
		System.out.println("num2: "+num2);
	}
	
	Object key1=new Object();
	Object key2=new Object();
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

class SyncObjectKeyAnswer{
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

**동기화** 는 **쓰레드의 접근 순서(방식)를 컨트롤한다** 는 의미이다.

쓰레드의 실행순서를 조절/결정하는 것도 동기화의 범주에 포함된다.

이전에 StringBuffer 클래스가 쓰레드에 안전하다고(Thread-safe하다고) 설명한적있다. 이는 StringBuffer 클래스에 이미 동기화 처리가 되어있어서, 둘 이상의 쓰레드가 동시에 접근을 해도 문제가 발생하지 않는다는 뜻이다. 때문에 이러한 클래스를 사용할 때에는 동기화를 적용할 필요가 없다. 혹시 앞서 공부한 ArrayList<E> 클래스와 HashSet<E>클래스에는 동기화 처리가 되어있는지 궁금하지 않은가? 그렇다면 API 문서를 통해서 확인하자. 다음과 같이 매우 진한 글씨체로 동기화 처리가 되어있지 않음을 명시하고 있으니 말이다. Note that this implementation is not synchronized. 동기화 처리 유무는 매우 중요한 정보에 해당한다. 따라서 문서를 꼼꼼히 살피지 않아도 해당 클래스의  동기화 처리 유무는 쉽게 확인할 수 있다.

---

9. 문자열이 있는 신문 클래스 신문작가(쓰레드)는 신문을 쓰고 독자(쓰레드)는 신문을 읽는다. _ 독자 실행 / 작가 실행

```
class NewsPaper{
	String todayNews;
	
	public void setTodayNews(String news){
		todayNews=news;
	}
	
	public String getTodayNews(){
		return todayNews;
	}
}

class NewsWriter extends Thread{
	NewsPaper paper;
	
	public NewsWriter(NewsPaper paper){
		this.paper=paper;
	}
	public void run(){
		paper.setTodayNews("자바의 열기가 뜨겁습니다.");
	}
}

class NewsReader extends Thread{
	NewsPaper paper;
	
	public NewsReader(NewsPaper paper){
		this.paper=paper;
	}
	public void run(){
		System.out.println("오늘의 뉴스: "+paper.getTodayNews());
	}
}

class NewsPaperStory{
	public static void main(String[] args)	{
		NewsPaper paper=new NewsPaper();
		NewsReader reader=new NewsReader(paper);
		NewsWriter writer=new NewsWriter(paper);

		reader.start();
		writer.start();

		try		{
			reader.join();
			writer.join();
		}
		catch(InterruptedException e)	{
			e.printStackTrace();
		}
	}
}
```

동기화는 쓰레드의 접근 순서/방식을 컨트롤한다는 의미이다.

앞서 보인 동기화는 순서에 상관 없이, 쓰레드의 동시 접근만을 막는 동기화였다. 그러나 쓰레드의 실행 순서를 조절/결정하는 것도 동기화의 범주에 포함된다.

"쓰레드의 실행순서는 소스코드가 나열된 순서와 다를 수 있다."

**쓰레드의 실행순서는 예측이 불가능하다.** 때문에 소스코드의 나열 순서를 가지고 쓰레드의 실행순서를 예측하는 것은 매우 어리석은 짓이다. 따라서 우리는 소스코드의 나열순서를 정리하는 방법이 아닌, 보다 확실한 방법으로 쓰레드의 실행순서를 컨트롤해야 한다.

*A쓰레드가 먼저 생성되었지만 늦게 생성된 B쓰레드가 먼저 실행되는 상황의 예  >> A 쓰레드와 B 쓰레드는 우선순위가 동일하다. 이러한 상황에서 A 쓰레드가 먼저 생성되고, 이어서 B 쓰레드가 생성되었다. 그리고는 먼저 생성된 A 쓰레드의 run 메소드가 호출되었는데, 그 순간 우선순위가 높은 C 쓰레드가 등장하여, A 쓰레드는 C 쓰레드에게 실행의 기회를 넘기고 말았다. 결국 A 쓰레드의 run 메소드는 하나도 실행되지 않은 상태가 되었다. 이어서 C 쓰레드는 종료되고, 이번에는 B 쓰레드의 run 메소드가 호출 및 실행되었다. 결과적으로 먼저 생성된 A 쓰레드보다 나중에 생성된 B 쓰레드가 먼저 실행되었다. 그리고 이는 하나의 예일뿐, 보다 다양한 상황에서 이와 유사한 일은 얼마든지 쉽게 일어날 수 있다.*

10. **쓰레드를 기다리게 하는 메소드의 원형**

>> public final void **wait()** throws InterruptedException

11. **하나의 쓰레드만 깨우는 메소드의 원형**

>> public final void **notify()**

12. **모든 쓰레드를 깨우는 메소드의 원형**

>> public final void **notifyAll()**

13. 9번문제를 동기화가 가능한 상태로 수정하자.(독자 두명 생성. 실행)

```
class NewsPaper{
	String todayNews;
	boolean isTodayNews=false;
	
	public void setTodayNews(String news){
		todayNews=news;
		isTodayNews=true;
		
		synchronized(this){
			notifyAll();		// 13행 모두 일어나세요
		}
	}
	
	public String getTodayNews(){
		if(isTodayNews==false){
			try{
				synchronized(this){
					wait();	// 25행 한숨 자면서 기다리겠습니다.
				}
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		return todayNews;
	}
}

class NewsWriter extends Thread{
	NewsPaper paper;
	
	public NewsWriter(NewsPaper paper){
		this.paper=paper;
	}
	public void run(){
		paper.setTodayNews("자바의 열기가 뜨겁습니다.");
	}
}

class NewsReader extends Thread{
	NewsPaper paper;
	
	public NewsReader(NewsPaper paper){
		this.paper=paper;
	}
	public void run(){
		System.out.println("오늘의 뉴스: "+paper.getTodayNews());
	}
}

class SyncNewsPaper{
	public static void main(String[] args){
		NewsPaper paper=new NewsPaper();
		NewsReader reader1=new NewsReader(paper);		// 71행
		NewsReader reader2=new NewsReader(paper);		// 72행
		NewsWriter writer=new NewsWriter(paper);		// 73행

		try{
			reader1.start();
			reader2.start();
			
			Thread.sleep(1000);			
			writer.start();
	
			reader1.join();
			reader2.join();
			writer.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
```

"wait와 notifyAll(notify) 메소드는 동기화 처리를 해서, **한 순간에 하나의 쓰레드만 호출이 가능하도록** 해야 한다."

위의 문장은, 두 메소드 wait와 notifyAll(notify)이 서로 다른 두 쓰레드에 의해서 동시에 각각 호출되는 것 조차 허용되지 않아야 함을 뜻하는 것이다. 위의 두 메소드는 동시에 호출되면 문제가 생길 수 있는 민감한 성격의 메소드이다. 따라서 동기화 블록 또는 동기화 메소드를 이용해서 메소드 호출문장을 동기화 처리해야 한다. 위 예제에서는 동기화 블록을 기반으로 동기화 처리를 하고 있다.

그리고 wait 메소드는 연이은 호출이 가능함에 주목해야 한다.(동시 호출이라고 하지 않았다.) 예를 들어서 A 쓰레드가 위 예제 25행에 있는 wait 메소드를 호출하면서 잠에 들었다고 가정해보자. 이 때 wait 메소드를 호출한 지점에서 잠이 든 것이기 때문에, 이 문장을 감싸는 동기화 블록을 완전히 벗어난 것은 아니다. 그러나 잠이 들면서 동기화 블록에 대한 경계까지도 완전히 풀어버리기 때문에(더 이상 실행중인 것이 아니라 그냥 잠이 들어버린 것이므로), 다른 쓰레드가 이 동기화 블록에 접근하는 것은 허용이 된다. 즉 다른 쓰레드에 의해서 25행의 wait 메소드는 또 다시 호출이 가능하다.

그럼 지금 설명한 내용을 바탕으로 위 예제를 다시 한번 관찰하자. 특히 71, 72행에서 데이터를 가져가기 위한 두 개의 쓰레드가 생성되어, 순서대로 wait 메소드를 호출하면서 잠이 들어버리는 상황을 연상해보자. 물론 이 두 쓰레드는 73행에서 생성되는 쓰레드의 notifyAll 메소드 호출을 통해 잠에서 깨어나게 된다. 참고로 notify 메소드는 잠이 든 여러 쓰레드들 중 하나만 깨울 때 사용되는 메소드이고, notifyAll 메소드는 잠이 든 모든 쓰레드들을 함께 깨울 때 사용되는 메소드이다. 13행의 메소드 호출문을 notify 호출문으로 변경해서 실행해 보면, 이 두 메소드의 차이를 쉽게 파악할 수 있을 것이다.

* wait와 notifyAll(notify) 메소드는 동기화 처리를 해서, 한 순간에 하나의 쓰레드만 호출이 가능하도록 해야 한다.
* notify 메소드는 잠이 든 여러 쓰레드들 중 하나만 깨울 때 사용되는 메소드이고, notifyAll 메소드는 잠이 든 모든 쓰레드들을 함께 깨울 때 사용되는 메소드이다.