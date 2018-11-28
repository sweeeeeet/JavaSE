public class TestCar{

public static void main(String[ ] args){
		Car car1=new Car("别克",1234);
	car1.setColour("蓝色");
	car1.setSeats(6);
	
	Car car2=new Car("宝马",5678,"红色",4);
	
	
	car1.printInfo();
	car2.printInfo();
		
	
	}
}