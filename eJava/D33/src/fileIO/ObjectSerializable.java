package fileIO;

import java.io.*;

class CircIe implements Serializable{
	int xPos;
	int yPos;
	double rad;
	
	public CircIe(int x, int y, double r){
		xPos=x;
		yPos=y;
		rad=r;
	}
	public void showCirlceInfo(){
		System.out.printf("[%d, %d] \n", xPos, yPos);
		System.out.println("rad: "+rad);
	}
}

class ObjectSerializable{
	public static void main(String[] args) 
					throws IOException, ClassNotFoundException{
		
		/* 인스턴스 저장 */
		ObjectOutputStream out= 
			new ObjectOutputStream(new FileOutputStream("Object.ser"));
		
		out.writeObject(new CircIe(1, 1, 2.4));
		out.writeObject(new CircIe(2, 2, 4.8));	
		out.writeObject(new String("String implements Serializable"));
		out.close();
		
		/* 인스턴스 복원 */
		ObjectInputStream in=
			new ObjectInputStream(new FileInputStream("Object.ser"));
		CircIe cl1=(CircIe)in.readObject();
		CircIe cl2=(CircIe)in.readObject();
		String message=(String)in.readObject();
		in.close();
		
		/* 복원된 정보 출력 */
		cl1.showCirlceInfo();
		cl2.showCirlceInfo();
		System.out.println(message);
	}
}


/*
Serializable 인터페이스를 구현하면 JVM에서 해당 객체는 저장하거나 다른 서버로 전송할 수 있도록 해준다.

그래서 직렬화가 무엇인가?

- 자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 
바이트(byte) 형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)을 아울러서 이야기합니다.

- 시스템적으로 이야기하자면 JVM(Java Virtual Machine 이하 JVM)의 메모리에 상주(힙 또는 스택)되어 있는 객체 데이터를 바이트 형태로 변환하는 기술과 
직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태를 같이 이야기합니다.
*/
