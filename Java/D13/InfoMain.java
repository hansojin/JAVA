import java.util.Scanner;

class InfoMain{

	private static final int INSERT_INFO =1;
	private static final int SEARCH_INFO = 2;
	private static final int DELETE_INFO = 3;
	private static final int PRINT_ALL_INFO = 4;
	private static final int QUIT_PROGRAM = 5;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int option=0;
		while(true){
			InfoBookUI.printOptions();
			option = sc.nextInt();
			sc.nextLine();
			switch(option){
			case INSERT_INFO:
				InfoBookUI.addData();
				break;

			case SEARCH_INFO:
				InfoBookUI.searchData();
				break;

			case DELETE_INFO:
				InfoBookUI.deleteData();
				break;

			case PRINT_ALL_INFO:
				InfoBookUI.printAllData();
				break;

			case QUIT_PROGRAM:
				InfoBookUI.printQuitProgram();
				return;

			default:
				InfoBookUI.printDefault();
			}
		}

		
	}
}