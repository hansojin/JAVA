package fileIOEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataFilterStream {
	public static void main(String[] args) {
		try(OutputStream out = new FileOutputStream("data.bin");
				DataOutputStream dOut = new DataOutputStream(out)){
			dOut.writeInt(275);
			dOut.writeDouble(45.79);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(InputStream in = new FileInputStream("data.bin");
				DataInputStream dIn = new DataInputStream(in)){
			int n1 = dIn.readInt();
			double n2 = dIn.readDouble();
			System.out.println(n1 + " " + n2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
