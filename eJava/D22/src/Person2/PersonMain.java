package Person2;

public class PersonMain {

	public static void main(String[] args) {
		Person person = new Person("Taemin",16);
		person.show();
		try {
			Person cpy = person.clone();
			cpy.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
