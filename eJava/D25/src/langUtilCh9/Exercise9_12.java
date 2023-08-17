package langUtilCh9;

class Exercise9_12
{
	public static int getRand(int start, int end) {
		return (int)(Math.random()*(Math.abs(end-start)+1))+end;
	}
	public static void main(String[] args){
		for(int i=0; i< 20; i++)
			System.out.print(getRand(1,-3)+",");
	}
}
