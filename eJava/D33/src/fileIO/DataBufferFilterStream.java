package fileIO;

import java.io.*;

class DataBufferFilterStream{
	public static void main(String[] args) throws IOException	{
		OutputStream out=new FileOutputStream("data2.bin");
		BufferedOutputStream bufFilterOut=new BufferedOutputStream(out);
		DataOutputStream dataFilterOut=new DataOutputStream(bufFilterOut);
		
		dataFilterOut.writeInt(275);
		dataFilterOut.writeDouble(45.79);
		dataFilterOut.close();
		
		InputStream in=new FileInputStream("data2.bin");
		BufferedInputStream bufFilterIn=new BufferedInputStream(in);
		DataInputStream dataFilterIn=new DataInputStream(bufFilterIn);
		int num1=dataFilterIn.readInt();
		double num2=dataFilterIn.readDouble();
		dataFilterIn.close();
		
		System.out.println(num1);
		System.out.println(num2);		
	}
}