package phoneBook;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.TreeSet;

public class PhoneBook {

	private static PhoneBook pb;
	private TreeSet<PhoneInfo> set;

	private PhoneBook() {
		set = new TreeSet<PhoneInfo>();
	}

	public static PhoneBook getPhoneBook(){
		if(pb==null)
			pb = new PhoneBook();
		return pb;
	}

	public boolean insertPhoneInfo(PhoneInfo phoneInfo){		
		return set.add(phoneInfo);
	}

	public boolean searchPhoneInfoByName(String name){
		PhoneInfo pInfo = null;
		Iterator<PhoneInfo> itr = set.iterator();
		boolean result = false;

		while(itr.hasNext()){			
			pInfo = itr.next();
			if(pInfo.getName().equals(name)){
				pInfo.printCurrentState();
				result = true;
			}
		}

		return result;
	}

	public boolean deletePhoneInfoByPhoneNumber(String phoneNumber){
		PhoneInfo pInfo = null;
		Iterator<PhoneInfo> itr = set.iterator();

		while(itr.hasNext()){			
			pInfo = itr.next();
			if(pInfo.getPhoneNumber().equals(phoneNumber)){
				itr.remove();
				return true;
			}
		}
		return false;
	}

	public void printAllPhoneInfo(){
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()){
			itr.next().printCurrentState();
		}
		/*
		for(PhoneInfo info: set)
			info.printCurrentState();
		*/
	}
	
	public void getData(){
		try(ObjectInputStream in=
				new ObjectInputStream(new FileInputStream("Personal.ser"))){
			
			if(in!=null) {
				PhoneInfo phoneInfo = (PhoneInfo)in.readObject();
				while(phoneInfo!=null) {
					insertPhoneInfo(phoneInfo);
					try {
						phoneInfo = (PhoneInfo)in.readObject();
					}catch(EOFException e) {
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			File file = new File("Personal.ser");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void saveData() {
		try(ObjectOutputStream out= 
				new ObjectOutputStream(new FileOutputStream("Personal.ser"))){
			Iterator<PhoneInfo> iter = set.iterator();
			while(iter.hasNext())
				out.writeObject(iter.next());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}