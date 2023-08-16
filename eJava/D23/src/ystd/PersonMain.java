package ystd;

class Person implements Cloneable{
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void show() {
		System.out.println(name + " " + age);		
	}

	@Override
	protected Person clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Person)super.clone();
	}
	
	
}

public class PersonMain {
	public static void main(String[] args) {
		Person p = new Person("JH",28);
		p.show();
		try {
			Person cpy = p.clone();
			cpy.show();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} 
			
		
	}
}
