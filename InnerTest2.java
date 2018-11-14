class Outer{
//定义外部类的私有属性
private String s="this is 外部类";

//声明内部类
public class Inner{
	//定义内部类的方法	
	public void add(int x,int y){
		
		System.out.println(x+"+"+y+"="+(x+y));
		
	}
	public void getStr(){
		
		//内部类中直接访问外部类成员属性
		System.out.println(s);
	}
}

//从外部调用内部类的方法
public void getInofo(){
	
	//匿名内部类对象调用外部类方法
	new Inner().getStr();
	//声明创建内部类实例对象
	Inner in = new Inner();
	//实例调用内部类方法
	in.add(7,8)；
}
}

public class InnerTest2{
	
	
	public static void main(String[] args){
		//在其他类中创建外部类的实例对象
		Outer out=new Outer();
		//外部类实例调用外部类的方法
		out.getInofo();
		//在其他类中创建内部类的实例对象
		Outer.Inner in = new Outer().new Inner();
		//调用内部类的方法
		in.add(1,2);
		in.getStr();
	}
}