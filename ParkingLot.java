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
		System.out.println("可停入小型停车位");
		}
	}
	
	else if((car.width()<2f&&car.width()>1f)&&(car.length()<5f&&car.length()>3f)){
	if(num>0){
		System.out.println("可停入中型停车位");
		}
	}
	
	else if(car.width()<5f&&car.width()>2f&&car.length()<10f&&car.length()>5f){
		if(num>0){
		System.out.println("可停入大型停车位");
		
			}
		}
	System.out.println("剩余停车位为："+(--num));
	}
}


interface Car{
	float width();
	float length();
}


class Motor implements Car{
	public float width(){
		System.out.println("Motor宽0.5m");
		return 0.5f;
	}
	public float length(){
		System.out.println("Motor长1.5m");
		return 1.5f;
	}
	//覆写了object类中的同string（）；Java中所有的类都继承object

}
class Auto implements Car{
	public float width(){
		System.out.println("Auto宽1.5m");
		return 1.5f;
	}
	public float length(){
		System.out.println("Auto长2.5m");
		return 2.5f;
	}
}
class Truck implements Car{
	public float width(){
		System.out.println("Truck宽2.5m");
		return 2.5f;
	}
	public float length(){
		System.out.println("Truck长5.5m");
		return 5.5f;
	}
}
class Bus implements Car{
	
	public float width(){
		System.out.println("Bus宽2.5m");
		return 2.5f;
	}
	public float length(){
		System.out.println("Bus长8.5m");
		return 8.5f;
	}
}

