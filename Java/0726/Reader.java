import java.io.*;

class Reader{
	public static void main(String[] args){
		try {
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			System.out.print("정수 입력: ");
			String str=br.readLine();
			int num=Integer.parseInt(str);
			System.out.println("입력된 정수: "+num);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

/*
Scanner 가 없던 시절에 사용하던 방법으로, 

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

형태로 자주 쓰고, 
일단 맨 우측의 System.in은 콘솔에서 데이터를 입력받을 때 사용함.

System.in 으로 받은 InputStream 객체에 read함수를 실행하면,
1byte밖에 읽지 못해 2byte인 한글은 읽을 수 없기 때문에 InputStreamReader를 사용

InputStreamReader는 InputStream객체를 입력으로 가지고 있어야 하기 때문에 
new InputStreamReader(System.in)과 같은 형태를 지니며, 
이에 따라 byte로 받는 수준에서 char로 받을 수 있게 되었음. 

하지만 배열 크기를 일일이 지정해줘야하는 불편함은 여전함
그래서, 사용되는게 BufferedReader.
BufferedReader는 inputStreamReader를 입력받아 문자열을 출력하는데,
\n이 입력되기 직전까지 받은 모든 텍스트를 저장하고 
stream이 다 차거나, null이 아니라면 그 값을 계속 유지하기 때문에
데이터를 많이 입력받는 경우, Scanner 보다 메모리적으로 더 효율적임

*/