package memory;

class ShwThread extends Thread{
	
	public ShwThread(String threadName){
		super(threadName);
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println(getName());
			try {
				sleep(100);		//0.1sec
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadTest2 {
	public static void main(String[] args) {
		ShowThread th1 = new ShowThread("A");
		ShowThread th2 = new ShowThread("B");
		th1.start();	
		th2.start();
	}
}
