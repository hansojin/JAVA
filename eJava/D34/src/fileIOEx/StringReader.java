package fileIOEx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringReader {
	public static void main(String[] args) {
		try(BufferedReader in = new BufferedReader(new FileReader("Park.txt"))){
			String str;
			while(true) {
				str= in.readLine();
				if (str==null) break;
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
