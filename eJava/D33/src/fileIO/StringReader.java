package fileIO;

import java.io.*;

class StringReader{
	public static void main(String[] args) throws IOException	{
		BufferedReader in= new BufferedReader(new FileReader("Strint.txt"));
		
		String str;
		while(true)	{
			str=in.readLine();
			if(str==null)
				break;
			
			System.out.println(str);
		}
		in.close();
	}
}