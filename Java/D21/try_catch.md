*[참고] if 문과 달리, try블럭이나 catch 블럭 내에 포함된 문장이 하나뿐이어도 괄호{} 를 생략할 수 없다.*
```
import java.util.Scanner;
import java.util.InputMismatchException;

class ExceptionCase{ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number1 :  ");
            int n1 = sc.nextInt();
            
            System.out.print("Enter number2 :  ");
            int n2 = sc.nextInt();
        
            System.out.printf("%d / %d = %d \n", n1, n2, n1/n2);
        }
        catch(ArithmeticException e) {
            e.getMessage();
        }
        catch(InputMismatchException e) {
	// 클래스 Scanner를 통한 값의 입력에서의 오류 상황을 의미하는 예외 클래스
            e.getMessage();
        }

        System.out.println("Bye~~!");
    }
}
```


위의 소스 코드의 catch 블록을 하나로 합치면

```
import java.util.Scanner;
import java.util.InputMismatchException;

class ExceptionCase{ 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number1 :  ");
            int n1 = sc.nextInt();
            
            System.out.print("Enter number2 :  ");
            int n2 = sc.nextInt();
        
            System.out.printf("%d / %d = %d \n", n1, n2, n1/n2);
        }
        catch(ArithmeticException | InputMismatchException e) {
            e.getMessage();
        }

        System.out.println("Bye~~!");
    }
}
```
*[참고] 예외처리는 성능의 저하로 이어진다.*

try 구문 안에 위치한 코드는 try 구문 밖에 위치한 코드에 비해 실행 속도가 느리다. 따라서 과도한 예외처리는 심각한 성능의 저하로 이어질 수 있다. 따라서 예외처리가 불필요한 코드를 try 구문 안에 두는 일을 자제해야 한다. 참고로 모든 예외를 민감하게 처리하는 프로그램은 생각보다 많지 않다. 규모가 클수록, 성능이 중요시될수록 try~catch문 이외의 다양한 방법으로 그리고 선별적으로 예외를 처리한다.