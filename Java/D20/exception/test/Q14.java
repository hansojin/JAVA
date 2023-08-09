import java.util.Scanner;

class NameLenEx extends Exception{
	public NameLenEx(){
		super("name must be longer than 1 word");
	}
}

class AgeBoundEx extends Exception{
	public AgeBoundEx(){
		super("age can't be negative");
	}
}

class Q14{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		try{
			System.out.print("Enter name : ");
			name = sc.nextLine();
			if (name.length() <2 )
				throw new NameLenEx();
			System.out.println("name : " + name);
			
			System.out.print("Enter age : ");
			age = sc.nextInt();
			if (age<0)
				throw new AgeBoundEx();
			System.out.println("age : " + age);
		} catch(NameLenEx e){
			e.printStackTrace();
		} catch(AgeBoundEx e){
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	
	}
}