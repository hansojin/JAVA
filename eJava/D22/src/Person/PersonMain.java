package Person;

public class PersonMain {

	public static void main(String[] args) {
		Person person = new Person("Taemin",16);
		person.show();
		try {
			Person cpy = (Person)person.clone();
			cpy.show();
		} 
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}

/*
 * clone()을 쓰려면, CloneNotSupportedException 을 반드시 사용해야 함!
 * try-catch 안에 담거나, throw new CloneNotSupportedException 하던가
 * 
 * clone 메서드를 오버라이드(override) 하고 있는 어플리케이션에서도, 
 * 객체를 복제할 수가 없는지, 혹은 객체를 복제해서는 안되는 것을 나타내기 위해 예외처리를 함
 */