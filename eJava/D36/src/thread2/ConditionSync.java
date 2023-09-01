package thread2;

/* 예제를 통해서 Condition 인스턴스 기반의 실행순서 동기화의 사례를 보여라. 
 * 이 예제에서는 두 개의 쓰레드가 생성되는데, 1. 프로그램 사용자로부터 문자열을 
 * 입력 받는 쓰레드와 2. 입력 받은 문자열을 출력하는 쓰레드다.
 */

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
		Scanner sc=new Scanner(System.in);
		String readStr;
		
		for(int i=0; i<5; i++){
			readStr=sc.nextLine();
			comm.setNewString(readStr);
		}
		sc.close();
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

class ConditionSync{
	public static void main(String[] args){
		StringComm strComm=new StringComm();
		StringReader sr=new StringReader(strComm);
		StringWriter sw=new StringWriter(strComm);
	
		System.out.println("입출력 쓰레드의 실행...");
		sr.start();
		sw.start();
	}
}
