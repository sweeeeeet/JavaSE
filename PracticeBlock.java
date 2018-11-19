class A{
	
	public int a= 10;
}
class Cup{
	
	public void print(){
		System.out.println("Cup类中的普通代码块");
	}
	
	public Cup(){
		System.out.println("这是CUP类的构造方法中的代码块");
	}
	//类中代码块为构造块
	{
		System.out.println("这是Cup类中的构造块");
	}	
	static{
		//最先执行且只执行一次
		System.out.println("Cup类中的静态构造块");
		
		//静态块中不能访问直接实例变量，需要通过类的对象访问
		A al=new A();
		System.out.println(al.a);
	}
	
}
//
public class PracticeBlock{
	
	
	{
		System.out.println("在主类中的构造代码块");
	}
	public PracticeBlock(){
		System.out.println("主类中的构造方法");
	}
	static{
		System.out.println("在主类中的静态代码块");
	}
	public static void main(String[] args){
		//创建一次对象就会调用一次构造块,构造块先于构造方法执行
		new Cup();
		System.out.println();
		
		Cup b = new Cup();
		System.out.println();
		
		b.print();
		System.out.println();
		
		new PracticeBlock();
		System.out.println();
		
		{
			System.out.println("主方法中的普通代码块");
		}
		System.out.println();
		
		PracticeBlock pa=new PracticeBlock();
		System.out.println();
		
	}
}