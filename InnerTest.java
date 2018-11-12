class Outer{
	private String msg = "这是写在外部类的私有属性";
	
	//定义一个成员内部类
	class Inner{
		int num=2;
		public void print(){
		
		//打印外部类的私有属性	
		System.out.println(msg);
		
		}
	}
	
	public void fun(){
		
		Inner in =new Inner();
		in.print();
		
	}
	
		
}
public class InnerTest{
	
	public static void main(String[] args){
		//创建外部类对象，调用内部类方法
		Outer ou =new Outer();
		ou.fun();
		
	}
}