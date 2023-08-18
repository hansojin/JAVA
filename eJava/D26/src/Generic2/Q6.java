package Generic2;

interface SimpleInterfacee{
	public void showYourName();
}

class UpperClasss{
	public void showYourAncestor(){
		System.out.println("UpperClasss");
	}
}

class AAAA extends UpperClasss implements SimpleInterfacee{
	public void showYourName()	{
		System.out.println("Class AAAA");
	}
}

class BBBB  extends UpperClasss implements SimpleInterfacee{
	public void showYourName() 	{
		System.out.println("Class BBBB");
	}
}

class Q6{	
	public static <T extends UpperClasss> void showInstanceAncestor(T param)	{
		param.showYourAncestor();		
	}
	
	public static <T extends SimpleInterfacee> void showInstanceName(T param)	{
		// interface 여도 implements 대신 extends 사용
		param.showYourName();
	}
	
	public static void main(String[] args)	{
		AAAA AAAA=new AAAA();
		BBBB BBBB=new BBBB();
		
		showInstanceAncestor(AAAA);
		showInstanceName(AAAA);
		showInstanceAncestor(BBBB);
		showInstanceName(BBBB);
	}
}