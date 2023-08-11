```
class Product {
	int price;			// 제품의 가격
	int bonusPoint;		// 제품구매 시 제공하는 보너스점수

	Product() {} 		// 기본 생성자

	Product(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}
}
 
class Tv extends Product {
	Tv() {
		super(100);	
	}
	public String toString() { 
		return "Tv"; 
	}
}

class Computer extends Product {
	Computer() { 
		super(200); 
	}
	public String toString() { 
		return "Computer"; 	
	}
}

class Audio extends Product {
	Audio() { 
		super(50); 
	}
	public String toString() { 
		return "Audio";
	}
}

class Buyer {			
	int money = 1000;			// 소유금액
	int bonusPoint = 0;		// 보너스점수
	Product[] item = new Product[10];	// 구입한 제품을 저장하기 위한 배열
	int i =0;				// Product배열에 사용될 카운터

	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족");
			return;
		}
		money -= p.price;	        
		bonusPoint += p.bonusPoint;	
		item[i++] = p;		        
		System.out.println(p + "을/를 구입하셨습니다.");
	}

	void summary() {		  		// 구매한 물품에 대한 정보 요약
		int sum = 0;		 	// 구입한 물품의 가격합계
		String itemList =""; 		// 구입한 물품목록

		for(int i=0; i<item.length;i++) {
			if(item[i]==null) break;
			sum += item[i].price;
			itemList += item[i] + ", "; 
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

class PolyArgumentTest2 {
	public static void main(String args[]) {
		Buyer b = new Buyer();

		b.buy(new Tv()); 
		b.buy(new Computer()); 
		b.buy(new Audio()); 
		b.summary();
	}
}
```

위 예제에서 Product 배열로 구입한 제품들을 저장할 수 있도록 했지만, 배열의 크기를 10으로 했기 때문에 11개 이상의 제품을 구입할 수 없는 것이 문제다. 그렇다고 해서 배열의 크기를 무조건 크게 설정할 수만도 없는 일이다.

이런 경우, **Vector클래스를 사용** 하면 된다. 

Vector클래스는 **내부적으로 Object 타입의 배열을 가지고 있어** 서, 이 배열에 객체를 추가하거나 제거할 수 있게 작성되어 있다. 그리고 배열의 크기를 알아서 관리해주기 때문에 저장할 인스턴스의 개수에 신경 쓰지 않아도 된다.

```
public class Vector extends AbstractList implements List, Cloneable, java.io.Serializable{
	protected Object elementData[];
	...
}
```

Vector클래스는 이름 때문에 클래스의 기능을 오해할 수 있는데, 단지 **동적으로 크기가 관리되는 객체배열** 일 뿐이다.


|메서드/생성자|설명|
|------|---|
|Vecotor()|10개의 객체를 저장할 수 있는 Vector인스턴스를 생성한다. 10개 이상의 인스턴스가 저장되면, 자동적으로 크기가 증가된다.|
|boolean add(Object o)|Vector에 객체를 추가한다. 추가에 성공하면 결과적으로 true,실패하면 false를 반환한다.|
|boolean remove(Object o)|Vector에 저장되어 있는 객체를 제거한다. 제거에 성공하면 true, 실패하면 false를 반환한다|
|boolean isEmpty()|Vector가 비어있는지 검사한다. 비어있으면 true, 비어있지 않으면 false를 반환한다.|
|Object get(int index)|지정된 위치(index)의 객체를 반환한다. 반환타입이 Object타입이므로 적절한 타입으로의 형변환이 필요하다.|
|int size()	|Vector에 저장된 객체의 개수를 반환한다.|