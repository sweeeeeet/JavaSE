public class ParkingLot{
	public static void main(String[] args){
		Parking parking=new Parking();
		// Car bus=new Bus();
		// Car moto=new Motor();
		// Car truck=new Truck();
		//parking.park(bus);
		
		//对象数组
		Car[] cars=new Car[]{
			new Bus(),
			new Auto(),
			new Motor()
		};
		for(int i=0;i<cars.length;i++){
			parking.park(cars[i]);
		}
	}
	
}

class Parking{
	int num=100;
	public void park(Car car){
		
	if(car.width()<1f&&car.width()>0f && car.length()<3f&&car.length()>0f){
		if(num>0){
			car.carInfo();
		System.out.println("可停入小型停车位");
		}
	}
	
	else if((car.width()<3f&&car.width()>1f)&&(car.length()<5f&&car.length()>2f)){
	if(num>0){
		car.carInfo();
		System.out.println("可停入中型停车位");
		}
	}
	
	else if(car.width()<5f&&car.width()>2f&&car.length()<10f&&car.length()>5f){
		if(num>0){
			car.carInfo();
		System.out.println("可停入大型停车位");
		
			}
		}
	System.out.println("剩余停车位为："+(--num));
	}
}


interface Car{
	float width();
	float length();
	void carInfo();
}


class Motor implements Car{
	public float width(){
		return 0.5f;
	}
	public float length(){
		return 1.5f;
	}
public void carInfo(){
		System.out.println("Motor宽0.5m");
		System.out.println("Motor长1.5m");
}
}
class Auto implements Car{
	public float width(){
		//
		return 1.5f;
	}
	public float length(){
		//
		return 2.5f;
	}
	public void carInfo(){
		System.out.println("Auto宽1.5m");
		System.out.println("Auto长2.5m");
}
}
class Truck implements Car{
	public float width(){
		return 2.5f;
	}
	public float length(){
		return 5.5f;
	}
		public void carInfo(){
		System.out.println("Truck宽2.5m");
		System.out.println("Truck长5.5m");
}
}
class Bus implements Car{
	
	public float width(){
		return 2.5f;
	}
	public float length(){
		return 8.5f;
	}
			public void carInfo(){
		System.out.println("Bus宽2.5m");
		System.out.println("Bus长8.5m");
}
}

