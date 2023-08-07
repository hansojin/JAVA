import java.util.Scanner;

class PhoneInfo{
	private String name,phone,birth;
	public PhoneInfo(String name, String phone, String birth){
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}
	public PhoneInfo(String name, String phone){
		this(name,phone,"");
	}
	public void showData(){
		System.out.println(name+"\t"+phone+"\t"+birth);
	}
	public String getName(){
		return name;
	}
	public String getPhone(){
		return phone;
	}
	
}

class PhoneUnivInfo extends PhoneInfo{
	private String major;
	private int year;
	public PhoneUnivInfo(String name, String phone, String major, int year){
		super(name,phone);
		this.major =major;
		this.year = year;
	}
	public void showData(){
		System.out.println(getName()+"\t"+getPhone()+"\t"+major+"\t"+year);
	}
}

class PhoneCompanyInfo extends PhoneInfo{
	private String company;
	public PhoneCompanyInfo(String name, String phone, String company){
		super(name,phone);
		this.company = company;
	}
	public void showData(){
		System.out.println(getName()+"\t"+getPhone()+"\t"+company);
	}
}

class PhoneHandler{
	Scanner sc;
	private PhoneInfo[] info;
	private int size, cnt,option;
	String name,phone,birth,major,company;
	int year;

	public PhoneHandler(int size){
		sc = new Scanner(System.in);
		info = new PhoneInfo[size];
		this.size=size;
		cnt=0;
	}

	public void description(){
		System.out.println();
		System.out.println(" ==options ==");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 모든 데이터 보기");
		System.out.println("5. 프로그램 종료");
		System.out.print("Enter number : ");
	}

	public void insertSort(PhoneInfo phone){
		
		if(cnt==0){
			info[cnt++]=phone;
		}
		
		else{
			int tmp=-1;
			for(int i=0;i<cnt;i++){
				if(phone.getName().compareTo(info[i].getName())<0){
					tmp=i;
					break;
				}
			}
			if (tmp==-1){
				info[cnt++] = phone;
			}else{
				for (int i=cnt;i>tmp;i--)
					info[i]=info[i-1];
				info[tmp]=phone;
				cnt+=1;
			}
			
		}
		
	}
	public void addData(){	
		System.out.println();
		System.out.println(" == Insert data == ");
		System.out.print("Enter 1 for 일반, 2 for 대학, 3 for 회사: ");
		option = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter name : ");
		name = sc.nextLine();
		System.out.print("Enter phone : ");
		phone = sc.nextLine();
		switch(option){
		case 1:
			System.out.print("Enter birth : ");
			birth = sc.nextLine();
			insertSort(new PhoneInfo(name,phone,birth));
			break;
		case 2:
			System.out.print("Enter major : ");
			major = sc.nextLine();
			System.out.print("Enter year : ");
			year = sc.nextInt();
			insertSort(new PhoneUnivInfo(name,phone,major,year));
			break;
		case 3:
			System.out.print("Enter company : ");
			company = sc.nextLine();
			insertSort(new PhoneCompanyInfo(name,phone,company));
			break;
		default:
			System.out.println("Enter between 1-3");
			break;
		}
		
	}
	
	public int nameSearch(){
		System.out.print("Enter searcher's name : ");
		name = sc.nextLine();
		int found=-1;
		for (int i=0;i<cnt;i++){
			if (info[i].getName().compareTo(name)==0){
				found=i;
				break;
			}
		}
		return found;
	}

	public void searchData(){
		int result = nameSearch();
		if (result!=-1)
			info[result].showData();
		
		else
			System.out.println("No data");
	}

	public void deleteData(){
		int result=nameSearch();
		if (result!=-1){
			for (int i=result;i<cnt-1;i++){
				info[i]=info[i+1];
			}
			info[cnt]=null;
			cnt-=1;
			System.out.println("Data deleted");
		}
		else
			System.out.println("No data");
	}

	public void printAllData(){
		for (int i=0;i<cnt;i++)
			info[i].showData();
	}	

	public void printExit(){
		System.out.println("program EXIT");
	}
	public void printError(){
		System.out.println("Enter between 1-5");
	}
}


class PhoneMain{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PhoneHandler handler = new PhoneHandler(100);
		while (true){
			handler.description();
			int num=sc.nextInt();
			sc.nextLine();
			switch(num){
			case 1: 
				handler.addData();
				break;
			case 2 : 
				handler.searchData();
				break;
			case 3:
				handler.deleteData();
				break;
			case 4:	
				handler.printAllData();
				break;
			case 5:
				handler.printExit();
				return;		
			default:
				handler.printError();
				break;
			}
		}
		
		
		
	}
}