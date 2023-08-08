import static java.lang.Math.PI;
import java.util.Arrays;

class ArrTest{
	public static void main(String[] args){

		int[] numArr1 = new int[10];
		int[] numArr2 = new int[10];

		Arrays.fill(numArr1, 5);

		System.out.println("PI : " + PI);	
		//System.out.println("PI : " + Math.PI);	
		System.out.println(Arrays.toString(numArr1));	//5555555555
		System.arraycopy(numArr1,0, numArr2,0, 5);
		System.out.println(Arrays.toString(numArr2));	//5555500000		
	}
}

/*
Instead of using Math.PI,
by importing 'static java.lang.Math.PI;' 
it support static import for comfort
*/