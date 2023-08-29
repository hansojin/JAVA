package fileIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class DataFilterStream{
	public static void main(String[] args) throws IOException	{
		OutputStream out=new FileOutputStream("data.bin");
		// 문자나 바이트 형식 문자
		DataOutputStream filterOut=new DataOutputStream(out);
		// 의 데이터를 변환해주어 읽고 쓰는 클래스 DataIOStream
		filterOut.writeInt(275);
		filterOut.writeDouble(45.79);
		filterOut.close();

		InputStream in=new FileInputStream("data.bin");
		DataInputStream filterIn=new DataInputStream(in);
		int num1=filterIn.readInt();
		double num2=filterIn.readDouble();
		filterIn.close();

		System.out.println(num1);
		System.out.println(num2);		
	}
}
