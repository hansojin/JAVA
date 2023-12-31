package OOP2;

class MyTv2 {

	private int channel;
	private int prevChannel; // (previous channel) 이전 채널

	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public void setChannel(int channel){
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL)
			return;
		prevChannel = this.channel; // . 현재 채널을 이전 채널에 저장한다
		this.channel = channel;
	}
	public int getChannel(){
		return channel;
	}
	public void gotoPrevChannel() {
		setChannel(prevChannel); // . 현재 체널을 이전 채널로 변경한다
	}
}
class Exercise7_10 {
	public static void main(String args[]) {
		MyTv2 t = new MyTv2();
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());

	}
}