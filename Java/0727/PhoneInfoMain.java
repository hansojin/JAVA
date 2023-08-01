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
		System.out.println(name + "\t" + phone + "\t"+birth);
	}
}


public class PhoneInfoMain{
	public static void main(String[] args){
		int cnt = 0;
		int menu = 0; 
		PhoneInfo info = null;
		Scanner sc = new Scanner(System.in);
		String name = null, phone = null, birth = null;
		PhoneInfo[] infoArr = new PhoneInfo[100];
		
		while(true){
			System.out.println("\n== 선택하세요 ==");
			System.out.println("1. 데이터 입력");
			System.out.println("4. 모든 데이터 보기");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 : ");
			menu = sc.nextInt();		
			sc.nextLine();		
			switch(menu){
			case 1:
				System.out.print("이름 : ");
				name = sc.nextLine();
				System.out.print("전화번호 : ");
				phone = sc.nextLine();
				System.out.print("생년월일 : ");
				birth = sc.nextLine();
		
				info = new PhoneInfo(name, phone, birth);
				infoArr[cnt++] = info;
				System.out.println("입력이 완료되었습니다.");				
				break;
			case 4:
				for(int i=0;i<cnt;i++)
					infoArr[i].showPhoneInfo();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}