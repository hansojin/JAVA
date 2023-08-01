class Cylinder{
	double radius, height, circle, volume;
	static double PI = 3.141592;
	
	public void init(double radius, double height){
		this.radius=radius;
		this.height=height;
		circleArea();
		cylinderVolume();
	}
	public void circleArea(){
		circle = radius*radius*PI;
	}
	public void cylinderVolume(){
		volume = circle*height;
		System.out.println(volume);
	}
}

class CylinderMain{
	public static void main(String[] args){
		Cylinder cy = new Cylinder();
		cy.init(2.8,5.6);
	}
}