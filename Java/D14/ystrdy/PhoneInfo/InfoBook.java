public class InfoBook{

	private static InfoBook book;
	private Info[] infoArr;
	private int cnt;

	private InfoBook(int size){
		infoArr = new Info[size];
	}
	
	public static InfoBook getInfoBook(int size){
		if (book==null)
			book=new InfoBook(size);
		return book;
	}

	public boolean checkSize(){
		if(cnt>=infoArr.length)
			return false;
		return true;
	}

	public void addData(String name,String phone, String birth){
		infoArr[cnt++] = new Info(name,phone,birth);
	}

	public int searchByName(String name){
		for(int i=0;i<cnt;i++){
			if (infoArr[i].getName().equals(name)){
				return i;	
			}
		}
		return -1;
	}
	
	public int searchData(String name){
		int search = searchByName(name);
		if(search!=-1){
			System.out.println("====== info ======");
			infoArr[search].showInfo();
			return search;
		}
		return -1;
			
	}
	public boolean deleteData(String name){
		boolean found =false;
		int search = searchByName(name);
		if(search!=-1){
			for(int i=search;i<cnt-1;i++){
				infoArr[i]=infoArr[i+1];
			}
			infoArr[cnt-1]=null;
			cnt-=1;
			found=true;
		}
		return found;
		
	}
	
	public void printAllData(){
		for(int i=0;i<cnt;i++){
			infoArr[i].showInfo();
		}
	}
	
}