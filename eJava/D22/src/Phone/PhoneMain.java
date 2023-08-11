package Phone;

public class PhoneMain implements PhoneMenuString {

	public static void main(String[] args) {
		int choice = 0;
		
		while (true) {
			try {
				PhoneUI.mainMenu();
				choice = PhoneUI.sc.nextInt();
				PhoneUI.sc.nextLine();
				
				if(choice <INPUT_PHONEINFO || choice > PROGRAM_QUIT)
					throw new MenuChoiceException(choice);
				
				switch(choice) {
				case INPUT_PHONEINFO:
					PhoneUI.inputMenu();
					PhoneUI.inputMenuChoice();
					break;
				case SEARCH_PHONEINFO:
					PhoneUI.searchPhoneInfo();
					break;
				case DELETE_PHONEINFO:
					PhoneUI.deletePhoneInfo();
					break;
				case SHOW_ALL_PHONEINFO:
					PhoneUI.showAllInfo();
					break;
				case PROGRAM_QUIT:
					return;
				}
			}catch (MenuChoiceException e) {
				System.out.println(e.getMessage());
				e.showWrongMenu();
			
			}
			
			
		}
		
	}

}
