package fileIOEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Circle implements Serializable{
	int xPos;
	int yPos;
	double rad;

	public Circle(int x, int y, double r){
		xPos=x;
		yPos=y;
		rad=r;
	}
	public void showCirlceInfo(){
		System.out.printf("[%d, %d] \n", xPos, yPos);
		System.out.println("rad: "+rad);
	}
}
public class ObjectSerializable {
	public static void main(String[] args) {
		try(ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream("Object.ser"))){
			out.writeObject(new Circle(1, 1, 2.4));
			out.writeObject(new Circle(2, 2, 4.8));	
			out.writeObject(new String("String implements Serializable"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(ObjectInputStream in = 
				new ObjectInputStream(new FileInputStream("Object.ser"))){
			Circle cl1=(Circle)in.readObject();
			Circle cl2=(Circle)in.readObject();
			String message=(String)in.readObject();
			
			cl1.showCirlceInfo();
			cl2.showCirlceInfo();
			System.out.println(message);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
