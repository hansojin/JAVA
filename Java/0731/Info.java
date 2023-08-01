public class Info{
	private String name, phone, birth;
	
	public Info(String name, String phone, String birth){
		this.name=name;
		this.phone=phone;
		this.birth=birth;
	}

	public Info(String name, String phone){
		this(name,phone,null);
	}

	public void showInfo(){
		System.out.println(name + "\t" + phone + "\t" + birth);
	}

	public String getName(){
		return name;
	}
}