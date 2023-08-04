class Speaker{
	private int volumeRate;
	
	public void showCurrentState(){
		System.out.println("볼륨 크기: "+ volumeRate);
	}
	public void setVolume(int vol){
		volumeRate=vol;
	}
}

class BaseEnSpeaker extends Speaker{
	private int baseRate;
	
	public void showCurrentState(){
		super.showCurrentState();
		System.out.println("베이스 크기: "+baseRate);
	}
	public void setBaseRate(int base){
		baseRate=base;
	}
}

class Overriding{
	public static void main(String[] args){
		BaseEnSpeaker bs=new BaseEnSpeaker();
		bs.setVolume(10);
		bs.setBaseRate(20);
		bs.showCurrentState();

		Speaker bss=new BaseEnSpeaker();	// 이렇게 쓰려면, 
		bss.setVolume(10);
		((BaseEnSpeaker)bss).setBaseRate(20);	
		bss.showCurrentState();
		/* 
		speaker에는 setbaseRate가 없기 때문에, 
		setbaseRate를 부를때, 참조타입을 명확하게 적어줘야 에러가 나지 않음!
		*/
	}
}