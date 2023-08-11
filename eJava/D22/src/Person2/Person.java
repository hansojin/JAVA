package Person2;

public class Person implements Cloneable {
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
	public Person clone() throws CloneNotSupportedException {
		return (Person)super.clone();
	}
	
	/* 
	 * Method overriding 시에, 자손 type의  자료형을 return 받을수 있게 됨 
	 * => clone()이 object 메소드인데, Object 대신 Person을 사용함
	 * 
	 * 그러면 main method에서 형변환 처리할 필요가 없어짐. (=공변 반환)
	 */
	
}
