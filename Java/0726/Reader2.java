import java.io.*;
import java.util.Arrays;

class Reader2{
	public static void main(String[] args){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// String
			System.out.print("문자열을 입력하세요 : ");
			String str=reader.readLine();
			System.out.println(str);
			// hello world

			// String[]
			System.out.print("문자열을 입력하세요 : ");
			String[] strArr = reader.readLine().split(" ");
			System.out.println(Arrays.toString(strArr));
			// [hello, world]
		
			// int
			System.out.print("숫자를 입력하세요 : ");
			int i = Integer.parseInt(reader.readLine());
			System.out.println(i);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

