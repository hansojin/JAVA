package fileIOEx;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterStream {
	public static void main(String[] args) {
		char ch1 = 'A';
		char ch2 = 'B';
		
		try(Writer out=new FileWriter("AB.txt")){
			out.write(ch1);
			out.write(ch2);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
