class Gun{
	int bullet;    	// 장전된 총알의 수
	
	public Gun(int bnum){
		bullet=bnum;
	}
	public void shut(){
		System.out.println("BBANG!");
		bullet--;
	}
	public int getBullet(){
		return bullet;
	}
}

class Police extends Gun{
	int handcuffs;	     // 소유한 수갑의 수
	
	public Police(int bnum, int bcuff){
		super(bnum);
		handcuffs=bcuff;
	}
	public void putHandcuff() {
		System.out.println("SNAP!");
		handcuffs--;
	}
	public int getHandcuffs(){
		return handcuffs;
	}
}

class HASInheritance{
	public static void main(String[] args){
		Police pman=new Police(5, 3);
		System.out.println(pman.getBullet());
		pman.shut();
		System.out.println(pman.getBullet());
		System.out.println(pman.getHandcuffs());
		pman.putHandcuff();
		System.out.println(pman.getHandcuffs());
	}
}