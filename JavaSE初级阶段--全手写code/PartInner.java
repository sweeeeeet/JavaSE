class Outer{
	//定义外部类的非静态私有属性
	private float f=0.1f;
	//定义外部类的静态私有属性
	private static int a=7;
	//定义外部类的普通方法
	public void fun(){
		
		//在普通方法里定义内部类称为局部（方法内部类）
		class Inner{
			//方法内部类中定义私有属性
			private float innerF=4.3f;
			public Inner(){
				System.out.println(f+"+"+innerF+"="+(f+innerF));
			}
		}
		//在外部类普通方法里创建内部类匿名对象,JVM才能加载方法内部类
		new Inner();
	}
	//外部类中定义静态方法
	public static void fun2(){
		//静态方法中定义内部类，也不能加sattic 和 访问修饰符
		class Inner2{
			private int i=2;
			public Inner2(){
				//在静态方法内部类中直接调用外部类的静态私有属性a
				System.out.println(i+"+"+a+"="+(i+a));
				//在静态方法内部类中直接通过匿名对象调用外部类的私有属性
				float temp= new Outer().f;
				System.out.println(i+"+"+temp+"="+(i+temp));
			}
		}
		//在外部类静态方法里创建内部类匿名对象
		new Inner2();
	}
}
public class PartInner{
	
	public static void main(String[] args){
		Outer out = new Outer();
		out.fun();
		out.fun2();
	}
}