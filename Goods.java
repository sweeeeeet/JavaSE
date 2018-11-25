class Goods{
	private static int num;
	private static String name;
	private static double price;
	{
		this.num=++num;
		this.name="-- [未上架]";
		this.price=0.0;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPrice(double price){
		this.price=price;
	}
	
	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	public void setNum(int num){
		this.num=num;
	}
	
	public int getNum(){
		return num;
	}
	
}