//抽象类，既可以有抽象方法，有可以有实例方法
abstract class Person{
	public static final String country="中国";
	private String name;
	public Person(){
		System.out.println("抽象类Person的无参构造方法 ");
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	//抽象方法，只有声明没有方法体
public abstract void tell();
}
class Student extends Person{
	public Student(){
		System.out.println("Student类的无参数构造方法");
	}
	public void tell(){
		System.out.println("我叫"+getName()+",是一名"+country+"人！");
	}
}
abstract class Shape{
	private float width;
	private float high;
	public Shape(){
		
	}
	public Shape(float width,float high){
		this.width=width;
		this.high=high;
	}
	public float getWidth(){
		return width;
		
	}
	public float getHigh(){
	return high;
}
	public abstract void area();
	public abstract void Circumference();
	
}
class Rectangle extends Shape{
	public Rectangle(){
		
	}
	public Rectangle(float width,float high){
		super(width,high);
	}
	public void area(){
		System.out.println("矩形面积："+(getWidth()*getHigh()));
	}
	public void Circumference(){
		System.out.println("矩形周长："+(getWidth()+getHigh())*2);
	}
	
}
abstract class Oval extends Shape{
	//若子类不能实现父类的方法，则要将该子类继续定义为抽象类
	public abstract void area();
	public abstract void Circumference();
}

abstract class A{
	public A(){//4.调用构造方法
		this.print();//5.调用B的print方法，因其为抽象方法，向子类中寻找方法的实现
	System.out.println("测试A父类的构造函数第几步执行");
	}
	public abstract void print();
	
}
class B extends A{
	private int num=100;
	public B(int num){//2.调用B的构造方法
		super();//3.调用父类的构造方法
		this.num=num;//7.为子类中属性赋值100
		System.out.println("测试B子类的构造函数第几步执行");
	}
	public void print(){//6.调用子类的print方法
		System.out.println(this.num);//7.输出30
	}
}

public class AbstractTest{
	public static void main(String[] args){
		// Student stu=new Student();
		// stu.setName("小米");
		// stu.tell();
		// Rectangle re=new Rectangle(1.5F,2.0F);
		// re.area();
		// re.Circumference();
		new B(30).print();//1.实例化子类对象
	}
}