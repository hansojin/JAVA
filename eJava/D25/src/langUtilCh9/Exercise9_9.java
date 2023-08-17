package langUtilCh9;

class Exercise9_9 {
	
	public static String delChar(String ori, String target) {
		char[] op = target.toCharArray();
		for(int i=0;i<op.length;i++) {
			ori=ori.replace(Character.toString(op[i]), "");
		}
		return ori;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)"+" -> " + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)"+" -> " + delChar("(1 2 3 4\t5)"," \t"));
		

	}
}
