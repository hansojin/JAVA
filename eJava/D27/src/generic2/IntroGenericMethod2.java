package generic2;

class AA{
	public String toString(){
		return "Class AA";
	}
}

class BB{
	public String toString(){
		return "Class BB";
	}
}

class InstanceTypeShower2{
	public <T, U> void showInstType(T inst1, U inst2)	{
		System.out.println(inst1);
		System.out.println(inst2);
	}
}

class IntroGenericMethod2{	
	public static void main(String[] args)	{
		AA AA=new AA();
		BB BB=new BB();
		
		InstanceTypeShower2 shower=new InstanceTypeShower2();
		shower.<AA, BB>showInstType(AA, BB);
		shower.showInstType(AA, BB);
	}
}