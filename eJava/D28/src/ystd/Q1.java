package ystd;

// 제네릭 메소드에 매개변수로 배열을 전달하는 형태로 정의및 호출해 보자.

class Q1 {
	public static <T> void showArr(T[] arr) {
		for (int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static void main(String[] args) {
		String[] arr = new String[] {
				"HI!", "hello","bye"
		};
		showArr(arr);
		
	}

}
