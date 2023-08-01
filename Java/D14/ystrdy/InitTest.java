class InitTest{
	static int cv = 1;
	        int iv = 1;	

	static { cv = 2; }	
	{ iv = 2; }		

	InitTest(){		
		iv = 3;
	}
}

/*
cv : 1 2 
iv : 1 2 3
*/