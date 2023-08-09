**NESTED** 
---
outer안에 static Inner class 인경우, main에서 바로 접근 가능

```
AAA.BBB ab = new AAA.BBB(); 
```

**Inner** 
---
그냥 Inner class면, main에서 outer객체를 통해서 접근 가능

```
AAA aaa = new AAA();
AAA.BBB bbb = aaa.new BBB();
```

**Local** 
---
Inner class 내 method를 접근할 수 없으니, interface를 사용해서 접근.

```
interface Readable{
	public void read();
}

class Outer{
	private String name;
	
	public Outer(String name){
		this.name = name;
	}

	public Readable localCreate(final int num){
		return new Readable(){
			public void read(){
				System.out.println(name);
				System.out.println(num);
			}
		};
		
	}
}

class LocalAno{
	public static void main(String[] args){
		Outer out = new Outer("JH");
		Readable local = out.localCreate(948);
		local.read();
	}
}
```

	
	