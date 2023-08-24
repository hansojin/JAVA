package ystdPhoneInfo;
public class MenuChoiceException extends Exception {
	private int choice;
	MenuChoiceException(int choice)
	{
		super("��ȿ���� ���� �޴� ���Դϴ�.");
		this.choice = choice;
	}
	public void showWrongMenu()
	{
		System.out.println( choice + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
		System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.");
	}
}