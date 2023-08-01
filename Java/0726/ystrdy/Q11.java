class Q11{
	public static void main(String[] args){
		String str="hell0World";
		boolean flag = true;
		for (int i=0;i<str.length();i++){
			if (str.charAt(i) >='0' && str.charAt(i) <='9'){
				flag=false;
				break;
			}
		}
		if (flag)
			System.out.println("알파벳으로만 이루어진 문자열");
		else
			System.out.println("숫자가 포함된 문자열");
	}
}