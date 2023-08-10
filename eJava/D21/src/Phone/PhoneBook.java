package Phone;

public class PhoneBook {
	private static PhoneBook pb;
	private PhoneInfo[] pInfoArr;
	private int cnt;
	
	public PhoneBook(int size) {
		pInfoArr = new PhoneInfo[size];
		cnt=0;
	}
	public static PhoneBook getPhoneBookInst(int size) {
		if (pb==null)
			pb = new PhoneBook(size);
		return pb;
	}
	
	public void inputPhoneInfo(PhoneInfo pInfo) {
		int i=0, j=0;
		if(cnt>=pInfoArr.length) {
			System.out.println("stackOver");
			return;
		}
		
		for(i=0;i<cnt;i++) {
			if(pInfoArr[i].getName().compareTo(pInfo.getName())>0) {
				for(j=cnt-1;j>=i;j--)
					pInfoArr[j+1]=pInfoArr[j];
				break;
			}
		}
		pInfoArr[i]=pInfo;
		cnt++;
		
	}
	
	public void searchPhoneInfo(String name) {
		int result = search(name);
		if (result!=-1)
			pInfoArr[result].showInfo();
		else
			System.out.println("No data");
	}
	
	public void deletePhoneInfo(int idx) {
		int i=0;
		for (i=idx;i<cnt-1;i++)
			pInfoArr[i]=pInfoArr[i+1];
		pInfoArr[i]=null;
		cnt-=1;
		System.out.println("Data deleted");
		
	}
	
	public int search(String name) {
		for(int i=0;i<cnt;i++) {
			if(pInfoArr[i].getName().compareTo(name)==0)
				return i;
		}
		return -1;
	}
	
	public void showAllPhoneInfo() {
		for(int i=0;i<cnt;i++)
			pInfoArr[i].showInfo();
	}
	
	
	
	
	
}
