package memory;

class Sum{
	int num;
	public Sum() { 
		num=0; 
	}
	public void addNum(int n) { 
		num+=n; 
	}
	public int getNum() { 
		return num; 
	}
}

class AdderThread extends Sum implements Runnable{
	int start, end;
	public AdderThread(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public void run() {
		for (int i=start;i<=end;i++)
			addNum(i);
	}
}

public class RunnableThread {
	public static void main(String[] args) {
		AdderThread at1 = new AdderThread(1, 10);
		AdderThread at2 = new AdderThread(11, 20);
		Thread th1 = new Thread(at1);
		Thread th2 = new Thread(at2);
		th1.start();
		th2.start();
		try {
			th1.join();	// Thread가 종료될 때까지 기다리게 됨
			th2.join();	// join()이 없다면, 아직 thread의 실행이 완료 되기전에 아래 코드를 진행시킴
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(at1.getNum()+at2.getNum());

	}
}
