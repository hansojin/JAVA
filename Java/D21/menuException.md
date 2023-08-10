MenuException이 다음과 같다면, main에서 아래와 같이 적어 볼 수 있겠다. 
```
public class MenuException extends Exception {
	private int wrongMenu;

	public MenuException(int wrongMenu) {
		super(wrongMenu + "은 없는 메뉴입니다.");
		this.wrongMenu = wrongMenu;
	}
}
```
예시 1
```
import java.util.Scanner;

public class MenuMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while (true) {
			System.out.println("1.메뉴2.메뉴3.메뉴4.메뉴");
			menu = sc.nextInt();
			try {
				if(menu < 1 || menu > 4) throw new MenuException(menu);
				switch (menu) {
				case 1:
					break;
				default:
					break;
				}
			} catch (MenuException e) {
				System.out.println(e.getMessage());
			}			
		}
	}
}
```
예시 2
```
import java.util.Scanner;

public class MenuMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while (true) {
			System.out.println("1.메뉴2.메뉴3.메뉴4.메뉴");
			menu = sc.nextInt();
			try {
				switch (menu) {
				case 1:
					break;
				default:
					throw new MenuException(menu);
				}
			} catch (MenuException e) {
				System.out.println(e.getMessage());
			}			
		}
	}
}
```