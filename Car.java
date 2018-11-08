
public class Car{
	private String brand;
	private int num;
	private String colour;
	private int seats;
	
	public Car(String brand){
		
		this.brand=brand;
		
	}
	public Car(String brand,int num){
		
		this.brand=brand;
		this.num=num;
	}
	
	public Car(String brand,int num,String colour,int seats){
		
		this(brand);
		this.num=num;
		this.colour=colour;
		this.seats=seats;
		
	}
	
	String getBrand(){
		return brand;
	}
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
	
	public void printInfo(){
		
		System.out.println("品牌："+brand+"，车牌号："+num+"，颜色："+colour+"，座位："+seats);
		
	}
	
	
}