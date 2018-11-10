
public class Car{
	private String brand;
	private int num;
	private String colour;
	private int seats;
	
	//构造函数
	public Car(String brand){
		
		this.brand=brand;
		
	}
	//构造函数重载
	public Car(String brand,int num){
		
		this.brand=brand;
		this.num=num;
	}
	//构造函数重载
	public Car(String brand,int num,String colour,int seats){
		
		this(brand);
		this.num=num;
		this.colour=colour;
		this.seats=seats;
		
	}
	
	//getter函数
	String getBrand(){
		return brand;
	}
	//setter函数
	void setBrand(String brand){
		this.brand=brand;
		
	}
	
	int getNum(){
		
		return num;
		
	}
	
	void setColour(String colour){
		this.colour=colour;
		
	}
	String getColour(){
		
		return colour;
	}
	void setSeats(int seats){
		this.seats=seats;
		
	}
	int getSeats(){
		return seats;
		
	}
	
	//普通方法，打印个属性
	public void printInfo(){
		
		System.out.println("品牌："+brand+"，车牌号："+num+"，颜色："+colour+"，座位："+seats);
		
	}
	
	
}