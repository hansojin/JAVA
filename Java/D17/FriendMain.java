import java.util.Scanner;

class Friend{
	private String name, phone, address;
	public Friend(String name, String phone, String address){
		this.name=name;
		this.phone=phone;
		this.address=address;
	}
	public void showData(){}
	public void showBasicInfo(){}
	public String getName(){
		return name;
	}
	public String getPhone(){
		return phone;
	}
	public String getAddress(){
		return address;
	}
}

class HighFriend extends Friend{
	private String company;

	public HighFriend(String name, String phone, String address, String company){
		super(name,phone,address);
		this.company=company;
	}

	public void showData(){
		System.out.println(getName() + "\t" +getPhone() + "\t" +getAddress() + "\t" +company);
	}
	public void showBasicInfo(){
		System.out.println(getName() + "\t" +getPhone() + "\t" +company);
	}
}

class UnivFriend extends Friend{
	private String major;
	
	public UnivFriend(String name, String phone, String address, String major){
		super(name,phone,address);
		this.major=major;
	}

	public void showData(){
		System.out.println(getName() + "\t" +getPhone() + "\t" +getAddress() + "\t" +major);
	}

	public void showBasicInfo(){
		System.out.println(getName() + "\t" +major);
	}

}

class FriendMain{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String name,phone,address,company,major;
		int num;

		Friend[] data = new Friend[100];
		int idx=0;

		while(true){
			System.out.println();
			System.out.println("1. 고교 친구 저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 전체 기본 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("Enter num : ");
			num = sc.nextInt();
			sc.nextLine();
			switch(num){
			case 1:
				System.out.print("Enter name: ");
				name = sc.nextLine();
				System.out.print("Enter phone: ");
				phone = sc.nextLine();
				System.out.print("Enter address: ");
				address = sc.nextLine();
				System.out.print("Enter company: ");
				company = sc.nextLine();
				data[idx++] = new HighFriend(name,phone,address,company);
				break;
			case 2:
				System.out.print("Enter name: ");
				name = sc.nextLine();
				System.out.print("Enter phone: ");
				phone = sc.nextLine();
				System.out.print("Enter address: ");
				address = sc.nextLine();
				System.out.print("Enter major: ");
				major = sc.nextLine();
				data[idx++] = new UnivFriend(name,phone,address,major);
				break;
			case 3:
				for(int i=0;i<idx;i++){
					data[i].showData();
				}
				break;
			case 4:
				for(int i=0;i<idx;i++){
					data[i].showBasicInfo();
				}
				break;
			case 5:
				System.out.println("EXIT");
				return;
			default: 		
				System.out.println("Enter between 1-5");
				break;
			}
		}
	}
}


