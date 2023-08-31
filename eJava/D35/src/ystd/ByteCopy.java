package ystd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteCopy {
	public static void main(String[] args) {
		try(InputStream in=new FileInputStream("org.bin");
				OutputStream out=new FileOutputStream("cpy.bin");
				BufferedInputStream bin=new BufferedInputStream(in);
				BufferedOutputStream bout=new BufferedOutputStream(out)){
			int copyByte=0;
			int bData;
			
			while(true) {
				bData=bin.read();
				if (bData==-1) break;
				bout.write(bData);
				copyByte++;
			}
			System.out.println("복사된 바이트 크기 "+ copyByte);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
