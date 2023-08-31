package fileIO;

import java.io.File;

public class IOTest3 {
	public static void main(String[] args) {
		File myFile=new File("C:" + File.separator + "MyJava" + File.separator + "my.bin");
		if(myFile.exists()==false){
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
			return;
		}
		
		File reDir=new File("C:" + File.separator + "YourJava");
		if(reDir.mkdir())
			System.out.println("디렉토리 생성 성공");
		else
			System.out.println("디렉토리 생성 실패");

		File reFile=new File(reDir, "my.bin");
		if(myFile.renameTo(reFile))
			System.out.println("파일 이동 성공");
		else
			System.out.println("파일 이동 실패");

	}
}
