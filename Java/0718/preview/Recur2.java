class Recur2{
	public static int sum(int start, int end){
		if (end>start)
			return start+sum(start+1,end);
		else
			return end;
	}

	public static void main(String[] args){
		System.out.println(sum(1,10));
	}
}