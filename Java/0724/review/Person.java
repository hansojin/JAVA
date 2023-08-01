public class Person{
	private String name;
	private int age;

	public Person (){}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	
}

class PersonMain{
	public static void main(String[] args){
		Person person = new Person();

		person.setName("SJ");
		System.out.println(person.getName());
		person.setAge(23);
		System.out.println(person.getAge());

	}
}