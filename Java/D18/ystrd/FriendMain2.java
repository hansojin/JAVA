import java.util.Scanner;

class Friend{
	private String name, phone, address;

	public Friend(String name, String phone, String address){
		this.name= name;
		this.phone= phone;
		this.address =address;
	}

	public void showData(){
		System.out.print(name +"\t"+phone+"\t"+address+"\t");
	}
	public void showBasicInfo(){
		System.out.print(name+"\t");
	}
	
	public String getPhone(){
		return phone;
	}
}

class HighFriend extends Friend{
	private String company;

	public HighFriend(String name, String phone, String address, String company){
		super(name,phone,address);
		this.company=company;
	}

	public void showData(){
		super.showData();
		System.out.print(company);
		System.out.println();
	}

	public void showBasicInfo(){
		super.showBasicInfo();
		System.out.print(getPhone()+"\t"+company);
		System.out.println();
	}
}

class UnivFriend extends Friend{
	private String major;

	public UnivFriend(String name, String phone, String address, String major){
		super(name,phone,address);
		this.major=major;
	}

	public void showData(){
		super.showData();
		System.out.print(major);
		System.out.println();
	}

	public void showBasicInfo(){
		super.showBasicInfo();
		System.out.print(major);
		System.out.println();
	}
}
class FriendInfoHandler{
	private Friend[] data;
	private int idx;
	
	public FriendInfoHandler(int num){
		data = new Friend[num];
		idx=0;
	}
	
	private void addFriendInfo(Friend friend){
		data[idx++] = friend;
	}

	public void addFriend(int choice){
		String name, phone, address, major, company;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name : ");
		name = sc.nextLine();
		System.out.print("Enter phone : ");
		phone = sc.nextLine();									System.out.print("Enter address : ");
		address = sc.nextLine();
		if (choice==1){
			System.out.print("Enter major : ");
			major = sc.nextLine();
			addFriendInfo(new HighFriend(name,phone,address,major));
		}
		else{
			System.out.print("Enter company : ");
			company = sc.nextLine();
			addFriendInfo(new UnivFriend(name,phone,address,company));
		}
	}
	public void showData(){
		for(int i=0;i<idx;i++)
			data[i].showData();
	}
	public void showBasicInfo(){
		for(int i=0;i<idx;i++)
			data[i].showBasicInfo();
	}
}
class FriendMain2{
	public static void main(String[] args){
		FriendInfoHandler fh = new FriendInfoHandler(100);
		Scanner sc = new Scanner(System.in);
		int num;

		while (true){
			System.out.println();
			System.out.println(" == options == ");
			System.out.println("1. 고교 정보 저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 기본 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("Enter number : ");
			num = sc.nextInt();
			sc.nextLine();

			switch(num){
			case 1: case 2:
				fh.addFriend(num);
				break;
			case 3:
				fh.showData();
				break;
			case 4:
				fh.showBasicInfo();
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


