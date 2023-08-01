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
	public String getName(){
		return name;
	}
}


public class PhoneInfoMain3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String name = null, phone = null, birth= null; 
		int cnt =0, option=0;
		
		PhoneInfo info = null;
		PhoneInfo[] infoArr = new PhoneInfo[100];

		boolean sflag = false;
		int idx=0;

		while (true){
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
				System.out.print("이름 : ");
				name = sc.nextLine();
				System.out.print("전화번호 : ");
				phone = sc.nextLine();
				System.out.print("생년월일 : ");
				birth = sc.nextLine();
				
				info = new PhoneInfo(name,phone,birth);
				infoArr[cnt++] = info;

				System.out.println("입력이 완료되었습니다.");		
				break;

			case 2:
				System.out.print("검색할 이름을 입력하세요 : ");	
				name = sc.nextLine();
				for(int i=0;i<cnt;i++){
					if(name.equals(infoArr[i].getName())){
						System.out.println("====== info ======");
						infoArr[i].showPhoneInfo();
						sflag=true;
					}
				}
				if (sflag == false)
					System.out.println(name+"님의 정보가 없습니다.");

				sflag=false;
				break;

			case 3:
				System.out.print("삭제할 이름을 입력하세요 : ");	
				name = sc.nextLine();
				for(int i=0;i<cnt;i++){
					if(name.compareTo(infoArr[i].getName())==0){
						idx=i;
						sflag=true;
						break;
					}
				}
				if (sflag == false)
					System.out.println(name+"님의 정보가 없습니다.");
	
				else{
					for(int i= idx;i<cnt-1;i++){
						infoArr[i]=infoArr[i+1];
					}
					infoArr[cnt-1]=null;
					cnt-=1;
					sflag=false;
					System.out.println("삭제가 완료되었습니다.");
				}
				break;
 
			case 4:
				System.out.println("====== info ======");
				for(int i=0;i<cnt;i++){
					System.out.print((i+1)+". ");
					infoArr[i].showPhoneInfo();
				}
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