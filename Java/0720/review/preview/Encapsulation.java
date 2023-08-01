class Medicine{
	public void take(){
		System.out.println("You need to take some rest!");
	}
}

class Pharmacy{
	Medicine med;
	public Pharmacy(){
		med=new Medicine();
	}
	public void take(){
		med.take();
	}
}

/*
class Patient{
	public void takeMedicine(Medicine med){
		med.take();
	}
}
*/

class Patient{
	public void goPharmacy(Pharmacy pm){
		pm.take();
	}
}
class Encapsulation{
	public static void main(String[] args){
		Patient p = new Patient();
		//p.takeMedicine(new Medicine());
		p.goPharmacy(new Pharmacy());
	}
}