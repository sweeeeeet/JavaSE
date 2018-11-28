
// 1. 请手写如下所示格式的个人信息 Java 代码：  
// Name: Mary    
// Post: HR Director 
// Sex: female    
// Age: 26 
// Tel: 18081318888   
// Adress: DaTun road no. 6,chaoyang,Beijing
class Student{
public String name="Mary";
public String post="HR Director";
public String sex="female";
public int age=26;
public String tel="18081318888";
public String adress="DaTun road no. 6,chaoyang,Beijing";



public void print(){
	
	System.out.print("Name:"+name+"\t\t");
	System.out.println("Post:"+post);
	System.out.print("Sex:"+sex+"\t\t");
	System.out.println("Age:"+age);
	System.out.print("Tel:"+tel+"\t\t");
	System.out.println("Adress:"+adress);
	
}
}
 
// 3 购物计算     小明去商场购买Ｔ恤 2 件，运动鞋 1 双，网球拍 2 个，
// 其中Ｔ恤价格为 245 元，
// 运动鞋 价格 370 元，
// 网球拍价格 345.5 元，
// 由于商场打折，购买 2 件以上打 8 折，
// 计算下小明一个 消费了多少钱？ 
 class ShopCalcu{
	 private  double tShirt=245.0;
	 private  double sportShoses=370;
	 private  double tennisRacket=345.5;
	 public double getTShirt(){
		 return tShirt;
	 }
	 public double getSportShoses(){
		 return sportShoses;
	 }
	 public double getTennisRacket(){
		 return tennisRacket;
	 }
	 public double calculator(int num){
	 double sum=tShirt*2+1*sportShoses+2*tennisRacket;
		 if(num>=2){
			 sum=sum*0.8;
			 return sum;
	 }
	 else{
		 return sum;
	 }
	 
 }
 }
 
 class Ticket{
	 ShopCalcu goods=new ShopCalcu();
	 int tShirtNum=2;
	 int shosesNum=1;
	 int tennisNum=2;
	 double tShirtPrice=tShirtNum*goods.getTShirt();
	 double shosesPrice=shosesNum*goods.getSportShoses();
	 double tennisPrice=tennisNum*goods.getTennisRacket();
	 public void printTicket(){
	 System.out.println("*********消费单*******");
	 System.out.println("购买物品\t单价\t\t个数\t\t金额");
	 System.out.println("T恤"+"\t\t"+goods.getTShirt() +"\t\t"+tShirtNum+"\t\t"+tShirtPrice);
	 System.out.println("运动鞋"+"\t\t"+goods.getSportShoses() +"\t\t"+shosesNum+"\t\t"+shosesPrice);
	 System.out.println("网球拍"+"\t\t"+goods.getTennisRacket() +"\t\t"+tennisNum+"\t\t"+tShirtPrice);
     System.out.println();
	 System.out.println("折扣\t八折");
	 System.out.println("消费总金额"+goods.calculator(5));
	 
	 System.out.println("实际交费\t"+1500);
	 System.out.println("找钱\t"+(int)(1500-goods.calculator(5)));
	 System.out.println("本次购物所获积分"+(int)(goods.calculator(5)*0.05));
	 }
 }
 
 //6输入本金，算出1年，2年，3年，5年后的本息是多少？
 //（1年利息2.25/100，2 年利息为2.7/100，3年利息3.24/100，5年利息3.6/100） 
 
	
 class CalcuMoney{
public void calculatorMoney(){
	int deposit=20000;
	System.out.println("存款金额为20000");
	double year1=deposit*(1+(2.25/100));
	double year2=deposit*(1+(2.7/100))*(1+(2.7/100));
	double year3=deposit*(1+3.24/100)*(1+3.24/100)*(1+3.24/100);
	double year5=deposit*(1+(3.6/100))*(1+(3.6/100))*(1+(3.6/100))*(1+(3.6/100))*(1+(3.6/100));
	System.out.println("存款一年的本息为："+year1);
	System.out.println("存款两年的本息为："+year2);
	System.out.println("存款三年的本息为："+year3);
	System.out.println("存款五年的本息为："+year5);
	}	
 }
 
 // 编写一个程序，根据矩形的长 length=6.9m（float 类型）和 width=10m（int 类型），
 // 计算 矩形周长和面积。（请在周长和面积的值后面加上它们个自的单位“m”和“㎡”
 // 周长必须 为 float 类型，面积必须为 int 类型。
 // 周长=2*（长+宽）；面积=长*宽。） 
 
 class Rectangle{
	 float length=6.9f;
	 float width=10f;
	 public float perimeter(){
		 float perimeter=length*2+width*2;
		return perimeter;
	 }
	 public int area(){
		 int area =(int)length*(int)width;
		 return area;
	 }
 }
public class HomeWork1{
	public static void main(String[] args){
		// Student stu= new Student();
		// stu.print();
		// ShopCalcu shop = new ShopCalcu();
		
		// System.out.print("消费总金额为：");
		// System.out.print(shop.calculator(5));
		// Ticket t =new Ticket();
		// t.printTicket();
		// CalcuMoney cal=new CalcuMoney();
		// cal.calculatorMoney();
		
		Rectangle rec=new Rectangle();
		System.out.println("面积是"+rec.area()+"㎡");
		System.out.println("周长是"+rec.perimeter()+"m");
	}
}