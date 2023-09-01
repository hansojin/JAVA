package thread4;

class Lambda1 {
	public static void main(String[] args) {
		Runnable task = () -> {
			int n1 = 10, n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " +  (n1+n2));
			
		};
		
		Thread t = new Thread(task);
		t.start();
		System.out.println("END " + Thread.currentThread().getName());
		// main과 생성된 스레드 중 무엇이 먼저 끝날지는 알 수 없음
	}
}
