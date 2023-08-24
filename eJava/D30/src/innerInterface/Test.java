package innerInterface;

interface MainConstants {
	//inner interface (중첩 인터페이스)
	interface View{
		void showResult(int result);
	}

	void clear();
}

public class Test implements MainConstants{
    public void clear(){
        //clear 구현 
    }
    
    class B implements MainConstants.View{
            public void showResult(int result){
                //showResult 구현 내용
            }
    }

}
