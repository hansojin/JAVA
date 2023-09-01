package thread;

class NcwsPaper{
	String todayNcws;
	boolean isTodayNcws=false;
	
	public void setTodayNcws(String Ncws){
		todayNcws=Ncws;
		isTodayNcws=true;
		
		synchronized(this){
			notifyAll();		// 13행 모두 일어나세요
		}
	}
	
	public String getTodayNcws(){
		if(isTodayNcws==false){
			try{
				synchronized(this){
					wait();	// 25행 한숨 자면서 기다리겠습니다.
				}
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		return todayNcws;
	}
}

class NcwsWriter extends Thread{
	NcwsPaper paper;
	
	public NcwsWriter(NcwsPaper paper){
		this.paper=paper;
	}
	public void run(){
		paper.setTodayNcws("자바의 열기가 뜨겁습니다.");
	}
}

class NcwsReader extends Thread{
	NcwsPaper paper;
	
	public NcwsReader(NcwsPaper paper){
		this.paper=paper;
	}
	public void run(){
		System.out.println("오늘의 뉴스: "+paper.getTodayNcws());
	}
}

class NewsPaperSync{
	public static void main(String[] args){
		NcwsPaper paper=new NcwsPaper();
		NcwsReader reader1=new NcwsReader(paper);		// 71행
		NcwsReader reader2=new NcwsReader(paper);		// 72행
		NcwsWriter writer=new NcwsWriter(paper);		// 73행

		try{
			reader1.start();
			reader2.start();
			
			Thread.sleep(1000);			
			writer.start();
	
			reader1.join();
			reader2.join();
			writer.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
