class Q4{
	public static void main(String[] args){
		try{
			int[] arr = new int[10];
			arr[-1]=5;
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}

		try{
			Object obj = new int[5];
			String str = (String)obj;
		} catch (ClassCastException e){
			System.out.println(e.getMessage());
		}

		try{
			int[] arr2 = new int[-1];
		} catch (NegativeArraySizeException e){
			System.out.println(e.getMessage());
		}

		try{
			String str = null;
			int len = str.length();
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		}

	}
}