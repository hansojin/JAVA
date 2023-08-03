class Car{
	private int gasolineGauge;
	Car(int gasolineGauge){
		this.gasolineGauge = gasolineGauge;
	}
	public void showCurrentGauge(){
		System.out.println("잔여 가솔린 : " + gasolineGauge);
	}
}

class HybridCar extends Car{
	private int electricGauge;
	HybridCar(int gasolineGauge, int electricGauge){
		super(gasolineGauge);
		this.electricGauge = electricGauge;
	}
	public void showCurrentGauge(){
		super.showCurrentGauge();
		System.out.println("잔여 전기량 : " + electricGauge);
	}	
}

class HybridWaterCar extends HybridCar{
	private int waterGauge;
	HybridWaterCar(int gasolineGauge, int electricGauge, int waterGauge){
		super(gasolineGauge, electricGauge);
		this.waterGauge = waterGauge;
	}

	public void showCurrentGauge(){
		super.showCurrentGauge();
		System.out.println("잔여 워터량 : " + waterGauge);
	}
}

class CarMain2{
	public static void main(String[] args){
		HybridWaterCar hwCar = new HybridWaterCar(100, 200, 300);
		hwCar.showCurrentGauge();
	}
}