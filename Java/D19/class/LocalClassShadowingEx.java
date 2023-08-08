public class LocalClassShadowingEx {
	int x = 10;
    	int y = 20;
    	static final int z = 30;
    
    	public void methodOne() {
        
        		class Inner {
            		//static int m = 40;
			// Cant declare static members in non static inner type
          			int x = 90;
            		static final int z = 100;
 
            		public void methodTwo(int x) {
                			System.out.println("x=> "+x);		//111
                			System.out.println("y=> "+y);		//20
                			System.out.println("z=> "+z);		//100
                			System.out.println("this.x=> "+this.x);	//90
                			System.out.println("LocalClassShadowingEx.this.x=> "+LocalClassShadowingEx.this.x);			//10
                			System.out.println("LocalClassShadowingEx.z=> "+LocalClassShadowingEx.z);			// 30
            		}
        		}
        
        		Inner i=new Inner();
        		i.methodTwo(111);
    	}
    
    	public static void main(String[] args) {
        		new LocalClassShadowingEx().methodOne();
    	}
}