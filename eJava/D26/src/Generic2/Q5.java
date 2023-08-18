package Generic2;

interface SimpleInterface{
	public void showYourName();
}

class UpperClass{
	public void showYourAncestor(){
		System.out.println("UpperClass");
	}
}

class AAA extends UpperClass implements SimpleInterface{
	public void showYourName()	{
		System.out.println("Class AAA");
	}
}

class BBB  extends UpperClass implements SimpleInterface{
	public void showYourName() 	{
		System.out.println("Class BBB");
	}
}

class Q5{	
	public static <T> void showInstanceAncestor(T param)	{
		((UpperClass)param).showYourAncestor();		
	}
	
	public static <T> void showInstanceName(T param)	{
		((SimpleInterface)param).showYourName();
	}
	
	public static void main(String[] args)	{
		AAA aaa=new AAA();
		BBB bbb=new BBB();
		
		showInstanceAncestor(aaa);
		showInstanceName(aaa);
		showInstanceAncestor(bbb);
		showInstanceName(bbb);
	}
}