class AccessWay{
	static int num=0;
	
	AccessWay(){
		incrCnt();			// <- constructor에서 ++ 해줌
	}
	public void incrCnt(){
		num++;
	}
}

class ClassVarAccess{
	public static void main(String[] args){
		System.out.println("num="+AccessWay.num);	//0
		AccessWay way=new AccessWay();	
		System.out.println("num="+AccessWay.num);	//1
		way.num++;	
		System.out.println("num="+AccessWay.num);	//2	
		AccessWay.num++;			
		System.out.println("num="+AccessWay.num);	//3	
	}
}