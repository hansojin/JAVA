package fileIOEx;

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

public class DataBufferFilterStream {
	public static void main(String[] args) {
		try(OutputStream out = new FileOutputStream("daTa.bin");
				BufferedOutputStream bOut = new BufferedOutputStream(out);
				DataOutputStream dOut = new DataOutputStream(bOut)){
			dOut.writeInt(5);
			dOut.writeDouble(6.7);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(InputStream in = new FileInputStream("daTa.bin");
				BufferedInputStream bIn = new BufferedInputStream(in);
				DataInputStream dIn = new DataInputStream(bIn)){
			int n1= dIn.readInt();
			double n2 = dIn.readDouble();
			System.out.println(n1 + " " + n2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
