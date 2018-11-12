class Outer{
	private String msg = "这是写在外部类的私有属性";
	 
	 //通过getter方法传递私有属性
	 public String getMsg(){
		return msg;
		 
	 }
	 public void fun(){
		 //创建其他类Inner的对象,调用Inner的print方法
		 Inner in=new Inner(this);
		 in.print();
	 }
	
		
}
//拆分内部类
	class Inner{
	
	//声明外部实例对象	
	private Outer out;
		
		//以其他类的对象为参数的构造方法
		public 	Inner(Outer out){
			//为对象参数赋值
			this.out=out;
			
		}
		
		public void print(){
		//外部对象调用打印外部类的方法
		System.out.println(out.getMsg());
		
		}
	}
	
public class InnerTest1{
	
	public static void main(String[] args){
		//创建外部类对象，调用外部类方法
		Outer ou =new Outer();
		ou.fun();
		
	}
}