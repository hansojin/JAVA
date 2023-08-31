package ystd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileReadWrite {
	public static void main(String[] args) {
		try(RandomAccessFile raf = new RandomAccessFile("raf.bin","rw")){
			System.out.println(">> write");
			System.out.println("now : " + raf.getFilePointer());
			
			raf.writeInt(525);
			System.out.println("now : " + raf.getFilePointer());
			raf.writeDouble(9.48);
			System.out.println("now : " + raf.getFilePointer());

			System.out.println("\n>> read");
			raf.seek(0);
			System.out.println("now : " + raf.getFilePointer());

			System.out.println(raf.readInt());
			System.out.println("now : " + raf.getFilePointer());
			System.out.println(raf.readDouble());
			System.out.println("now : " + raf.getFilePointer());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
