class Outer {
	public void methodOne() {
        		class Inner{
           			public void sum(int i,int j) {
                		System.out.println("The sum:"+(i+j));
           		}
        	}
        
        	// out side of this method Local Inner class can't be accessed
        	Inner i = new Inner();
        	i.sum(10,20);
        	i.sum(100,200);
    	}
    
   	 public static void main(String[] args) {
        		//Inner i = new Inner(); can not access
        		//new Outer().new Inner(); can not access
        		new Outer().methodOne();
		/*
		The sum:30
		The sum:300
		*/
   	}
}