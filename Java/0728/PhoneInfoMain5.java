import java.util.Scanner;

class PhoneInfo{
	private String name;
	private String phone;
	private String birth;

	public PhoneInfo(String name, String phone, String birth){
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}
	public void showPhoneInfo(){
		System.out.println(name + "\t" + phone + "\t"+ birth);
	}
	public String getName(){
		return name;
	}
}

class Manager{
	private PhoneInfo[] infoArr;
	private int cnt;

	public Manager(){
		infoArr = new PhoneInfo[100];
		cnt=0;
	}

	public int getCnt(){
		return cnt;
	}

	public void addData(String name, String phone, String birth){
		PhoneInfo info = new PhoneInfo(name,phone,birth);
		infoArr[cnt++] = info;
		System.out.println("데이터 입력이 완료되었습니다.");
		
	}
	
	public void searchData(String name){
		boolean found = false;
		for(int i=0;i<cnt;i++){
			if(infoArr[i].getName().equals(name)){
				infoArr[i].showPhoneInfo();
				found=true;
			}
		}	
		if (found==false)
			System.out.println("일치하는 데이터를 찾을 수 없습니다.");
	}

	public void deleteData(String name){
		boolean found = false;
		for (int i=0;i<cnt;i++){
			if(infoArr[i].getName().equals(name)){
				found=true;
				for(int  j=i;j<cnt-1;j++)
					infoArr[j]=infoArr[j+1];
			
				infoArr[cnt-1]=null;
				cnt-=1;
				System.out.println("데이터 삭제가 완료되었습니다.");
                			break;
			}
		}
		if (found==false)
			System.out.println("일치하는 데이터를 찾을 수 없습니다.");
	}
	
	public void printAllData(){
		for (int i=0;i<cnt;i++){
			System.out.print((i+1)+". ");
			infoArr[i].showPhoneInfo();	
		}
	}
}

public class PhoneInfoMain5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String name = null, phone = null, birth= null; 
		int option=0;

		Manager manager = new Manager();

		while(true){
			System.out.println("\n== 선택하세요 ==");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 모든 데이터 보기");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 : ");
			option = sc.nextInt();		
			sc.nextLine();
		
			switch(option){
			case 1: 
				if (manager.getCnt() <100){
					System.out.println("데이터 입력을 시작합니다.");
					System.out.print("이름 : ");
					name = sc.nextLine();
					System.out.print("전화번호 : ");
					phone = sc.nextLine();
					System.out.print("생년월일 : ");
					birth = sc.nextLine();
				
					manager.	addData(name,phone,birth);
				}
				else
					System.out.println("Array Full (MAX : 100)");
				break;

			case 2:
				System.out.print("검색할 이름을 입력하세요 : ");	
				name = sc.nextLine();
				manager.searchData(name);
				break;

			case 3:
				System.out.print("삭제할 이름을 입력하세요 : ");	
				name = sc.nextLine();
				manager.deleteData(name);
				break;
 
			case 4:
				System.out.println("====== info ======");
				manager.printAllData();
				break;

			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			
			default:
				System.out.println("잘못 입력하셨습니다.");

			}
		}
	}
}