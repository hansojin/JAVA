package ystd;

public class Q8 {
	public static int getRand(int s, int e) {
		return (int)(Math.random()*(Math.abs(e-s)+1))+Math.min(s, e);
	}
	public static void main(String[] args){
		for(int i=0; i< 20; i++)
			System.out.print(getRand(1,-3)+",");
	}

}
