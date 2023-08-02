class Q22{
	public static boolean isNumber(String str){
		boolean flag = true;
		char[] arr = str.toCharArray();
		
		for (int i=0;i<arr.length;i++){
			if (arr[i]>='0' && arr[i]<='9')
				continue;
			else{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String args[]) {
		String str = "123";
		System.out.println(str+ "는 숫자입니까? " + isNumber(str));
		str="1234o";
		System.out.println(str+ "는 숫자입니까? " + isNumber(str));
	}
}