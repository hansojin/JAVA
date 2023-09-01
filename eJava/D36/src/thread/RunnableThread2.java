package thread;

class AddThread extends Thread{	
	int start, end;
	int sum=0;
	
	public AddThread(int s, int e){
		start=s;
		end=e;
	}
	public void addNum(int n) {
		sum+=n;
	}
	public int getNum() {
		return sum;
	}
	public void run(){
		for(int i=start; i<=end; i++)
			addNum(i);
	}
}

class RunnableThread2{
	public static void main(String[] args){
		AddThread at1=new AddThread(1, 50);
		AddThread at2=new AddThread(51, 100);
		at1.start();
		at2.start();
		try{
			at1.join();
			at2.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("1~100 까지의 합: "+(at1.getNum()+at2.getNum()));
	}
}
