package fileIOEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {
	public static void main(String[] args) {
		try(InputStream in = new FileInputStream("org.bin");
				OutputStream out = new FileOutputStream("org.bin")) {
			int copyByte = 0;
			int bData;
			
			while(true) {
				bData = in.read();
				if (bData==-1)
					break;
				out.write(bData);
				copyByte+=1;
			}
			System.out.println("복사된 바이트 크기 : "+copyByte);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
