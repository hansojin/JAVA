package thread3;

class MssageSendingThread extends Thread{
	String Mssage;
	
	public MssageSendingThread(String str, int prio) {
		Mssage=str;
		setPriority(prio);
	}
	public void run(){
		for(int i=0; i<1000; i++){
			System.out.println(Mssage+"("+getPriority()+")");
			
			try{
				sleep(1);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}	
}

class PriorityTest3{
	public static void main(String[] args){
		MssageSendingThread tr1
			=new MssageSendingThread("First", Thread.MAX_PRIORITY);
		MssageSendingThread tr2
			=new MssageSendingThread("Second", Thread.NORM_PRIORITY);
		MssageSendingThread tr3
			=new MssageSendingThread("Third", Thread.MIN_PRIORITY);
		
		tr1.start();
		tr2.start();
		tr3.start();
	}
}

/*
실행결과를 보면, 높은 우선순위의 쓰레드가 둘씩이나 존재함에도 불구하고 꿋꿋이 실행되고 있는 가장 낮은 우선순위의 쓰레드를 볼 수 있다. 
비록 우선순위가 낮은 쓰레드라 하더라도 높은 우선순위의 쓰레드가 CPU를 양보해서 실행의 기회를 얻게 되면, 최소 단위의 실행 시간은 보장을 받는다. 
따라서 위와 같은 실행 결과를 보이는 것이다. 결론적으로 낮은 우선순위의 쓰레드도 충분히 실행의 기회를 얻을 수 있고, 또 실제로 실행도 된다.
*/