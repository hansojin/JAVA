package ystd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileWR {
	public static void main(String[] args) {
		try(OutputStream out = new FileOutputStream("file.txt"); 
				BufferedOutputStream bout= new BufferedOutputStream(out);
				DataOutputStream dout = new DataOutputStream(bout)){
			dout.writeInt(275);
			dout.writeDouble(45.79);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(InputStream in = new FileInputStream("file.txt");
				BufferedInputStream bin = new BufferedInputStream(in);
				DataInputStream din = new DataInputStream(bin)){
			int n=din.readInt();
			double m =din.readDouble();
			System.out.println(n+ " " + m);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
