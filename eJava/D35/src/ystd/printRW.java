package ystd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class printRW {
	public static void main(String[] args) {
		try(PrintWriter pw = new PrintWriter("print.txt")){
			pw.printf("hi %d",525);
			pw.println();
			pw.print("nevertheless");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try(BufferedReader br = new BufferedReader(new FileReader("print.txt"))){
			String str= null;
			while((str=br.readLine())!=null)
				System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
