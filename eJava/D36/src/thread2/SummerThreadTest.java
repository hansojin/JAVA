package thread2;

import java.util.Scanner;

/* main 메소드에서는 프로그램 사용자로부터 총 다섯 개의 정수를 입력 받아서 
 * 별도로 생성된 하나의 쓰레드에게 전달하고, 별도로 생성된 쓰레드는 전달받은 수의 총 합을 계산해서, 
 * 그 결과를 출력하는 프로그램을 작성해 보자. 이는 main 메소드를 실행하는 main 쓰레드와 
 * main 쓰레드로부터 전달받은 수의 총 합을 계산하는 별도의 쓰레드간 동기화에 관련된 문제이다. 
 */

class IntegerComm{
	int num=0;
	boolean isNewNum = false;

	public void setNum(int n){
		synchronized(this){
			if(isNewNum == true){	// 이미 입력 받은 값이 있으면, 기다려
				try{
					wait();
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			num=n;
			isNewNum = true;
			notify();
		}
	}
	public int getNum(){
		int retNum=0;
		synchronized(this){
			if(isNewNum==false){	// 새로운 수가 없다면 가져가지말고 기다려
				try{
					wait();
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			retNum = num;
			isNewNum = false;
			notify();
		}
		return retNum;
	}
}

class IntegerSummer extends Thread{
	IntegerComm comm;
	int sum;
	public IntegerSummer(IntegerComm comm)	{
		this.comm = comm;
	}
	public void run()	{
		for(int i=0;i<5;i++)
			sum += comm.getNum();
		System.out.println(">> SUM : " + sum);
	}
}

class SummerThreadTest{
	public static void main(String[] args)	{
		IntegerComm comm = new IntegerComm();
		IntegerSummer summer = new IntegerSummer(comm);
		summer.start();

		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.print("Enter num : ");
			comm.setNum(sc.nextInt());
		}
		sc.close();
		try	{
			summer.join();
		}
		catch(InterruptedException e)		{
			e.printStackTrace();
		}
	}
}
