package fileIOEx;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderStream {
	public static void main(String[] args) {
		char[] cbuf = new char[10];
		
		try(Reader in = new FileReader("AB.txt")) {
			int readCnt = in.read(cbuf,0,cbuf.length);
			for (int i=0;i<readCnt;i++)
				System.out.println(cbuf[i]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
