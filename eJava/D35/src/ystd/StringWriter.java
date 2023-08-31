package ystd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {
	public static void main(String[] args) {
		try(BufferedWriter out = new BufferedWriter(new FileWriter("str.txt"))){
			out.write("hello");
			out.newLine();
			out.write("world");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(BufferedReader in = new BufferedReader(new FileReader("str.txt"))){
			String str;
			while((str=in.readLine())!=null)
				System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
