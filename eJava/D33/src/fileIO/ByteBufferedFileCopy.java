package fileIO;

import java.io.*;

class ByteBufferedFileCopy{
	public static void main(String[] args) throws IOException{
		InputStream in=new FileInputStream("org.bin");
		OutputStream out=new FileOutputStream("cpy.bin");
		
		BufferedInputStream bin=new BufferedInputStream(in);
		//byte단위로 파일을 읽어 올때 사용하는 버퍼 스트림
		BufferedOutputStream bout=new BufferedOutputStream(out);
		
		int copyByte=0;
		int bData;
		
		while(true){
			bData=bin.read();
			if(bData==-1)
				break;
			
			bout.write(bData);
			copyByte++;
		}

		bin.close();
		bout.close();		
		System.out.println("복사된 바이트 크기 "+ copyByte);
	}
}