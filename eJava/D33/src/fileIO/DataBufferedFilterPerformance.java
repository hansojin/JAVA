package fileIO;

import java.io.*;

class DataBufferedFilterPerformance{
	public static void performanceTest(DataOutputStream dataOut) throws IOException	{
		long startTime=System.currentTimeMillis();
		for(int i=0; i<1000; i++)
			for(int j=0; j<1000; j++)
				dataOut.writeDouble(12.345);

		dataOut.flush();
		long endTime=System.currentTimeMillis();	
		System.out.println("경과시간: "+ (endTime-startTime));	
	}

	public static void main(String[] args) throws IOException	{
		OutputStream out1=new FileOutputStream("dataOne.bin");
		DataOutputStream dataOut=new DataOutputStream(out1);
		performanceTest(dataOut);	//경과시간: 3244
		dataOut.close();

		OutputStream out2=new FileOutputStream("dataTwo.bin");
		BufferedOutputStream bufFilterOut =new BufferedOutputStream(out2, 1024*10);
		DataOutputStream dataBufOut=new DataOutputStream(bufFilterOut);
		performanceTest(dataBufOut);	//경과시간: 45
		dataBufOut.close();
	}
}
