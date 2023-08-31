package ystd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Circle implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"))){
			out.writeObject(new Circle(1,1,2.4));
			out.writeObject(new Circle(2,2,5.5));
			out.writeObject(new String("I miss JH"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"))){
			Circle c1 = (Circle)in.readObject();
			Circle c2 = (Circle)in.readObject();
			String msg = (String)in.readObject();
			
			c1.showCirlceInfo();
			c2.showCirlceInfo();
			System.out.println(msg);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
