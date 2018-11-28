class Outer{
//外部类的成员属性
int i=10;
public class Inner{
	
	//内部类的同名成员属性
	int i=20;
	//内部类的方法
	public void getOuter(){
	System.out.println("i表示Inner的成员i："+i);//20
	System.out.println(this.i);//20
	System.out.println(Inner.this.i);//20
	System.out.println(Outer.this.i);//10

	}
}
//外部类的同名方法
public void getOuter(){
	
	System.out.println(Outer.this.i);//10
	
	}
}
public class InnerTest3{
	
	public static void main(String[] args){
		
		//通过匿名内部类的对象调用内部类的方法
		new Outer().new Inner().getOuter();
		
		//通过匿名外部类的对象调用外部类的方法
		new Outer().getOuter();		
	}
}