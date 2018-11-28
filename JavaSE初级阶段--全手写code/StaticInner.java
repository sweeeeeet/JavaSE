class Outer{
	
	//定义外部类属性
	private int a=4;
	//定义外部类静态属性
	private static int b=5;
	
	//定义静态内部类
	public static class Inner{

		private int x=5;//可定义非静态属性
		private static int y=6;//可定义静态属性
		//可定义非静态方法
		public void add(int x,int y){
			
			int temp=new Outer().a;
			//int temp=a;
			x=b;
			System.out.println(temp+"x"+x+"="+(temp+x));
		}
		//可定义静态方法
		public static void reduce(int x,int y){
			System.out.println(x+"-"+y+"="+(x-y));
		}
	}
	
	//外部类的普通方法
	public void getInfo(){
		//通过静态内部类的匿名对象调用内部类的方法
		new Inner().add(4,3);
		//可通过静态内部类的类名直接调用静态内部类的方法
		Inner.reduce(4,3);
	}
}
public class StaticInner{
	
	public static void main(String[] args){
		//创建外部类实例
		Outer out=new Outer();
		out.getInfo();
		//创建内部类实例
		Outer.Inner in =new Outer. Inner();
		in.add(4,3);
		in.reduce(4,3);
	}
}