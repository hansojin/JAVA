package Phone;

public class MenuChoiceException extends Exception {
	private int choice;

	public MenuChoiceException(int choice) {
		super("유효하지 않은 메뉴값입니다.");
		this.choice = choice;
	}
	
	public void showWrongMenu() {
		System.out.println(choice + " 에 해당하는 선택지가 없습니다. ");
		System.out.println("선택을 다시 진행합니다. ");
		
	}
	
	
}
