class Car{
	int gasolineGauge;
	Car(int gasolineGauge){
		this.gasolineGauge=gasolineGauge;
	}
}

class HybridCar extends Car{
	int electricGauge;
	HybridCar(int gasolineGauge, int electricGauge){
		super(gasolineGauge);
		this.electricGauge=electricGauge;
	}
}

class HybridWaterCar extends HybridCar{
	int waterGauge;
	HybridWaterCar(int gasolineGauge, int electricGauge, int waterGauge){
		super(gasolineGauge,electricGauge);
		this.waterGauge=waterGauge;	
	}
	public void showCurrentGauge(){
		System.out.println("잔여 가솔린 : " + gasolineGauge);
		System.out.println("잔여 전기량 : " + electricGauge);
		System.out.println("잔여 워터량 : " + waterGauge);
	}
}

class CarMain{
	public static void main(String[] args){
		HybridWaterCar hc = new HybridWaterCar(10,20,30);
		hc.showCurrentGauge();
	}
}