public class Q12{
	public static void main(String[] args){

		for(int i=2;i<=8;i+=3){
			for(int j=1;j<=3;j++){
				if(i!=8){
					System.out.println(i + "*" + j+ "=" + i*j + "\t" + (i+1) + "*" + j+ "=" + (i+1)*j + "\t" + (i+2) + "*" + j+ "=" + (i+2)*j);
				}
				else{
					System.out.println(i + "*" + j+ "=" + i*j + "\t" + (i+1) + "*" + j+ "=" + (i+1)*j);
				}
			}
			System.out.println();
		}

		

	}
}