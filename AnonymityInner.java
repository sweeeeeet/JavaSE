abstract class AbstrClass{//定义抽象类
	
	public abstract void getInfo();//声明抽象类
	
} 
class Inner{//定义类Inner(匿名内部类)
	
	public void print(){
		//在print方法中调用show方法，show方法的形参中开辟了抽象类的匿名对象
		show(new AbstrClass(){  
			public void getInfo(){ //实现了抽象类中的方法
				
			System.out.println("Java匿名内部类");
			}
		});
	}
	public void show(AbstrClass a){//定义show 方法，形参为AbstrClass类的实例对象
		
		a.getInfo();
	}
}



interface Inter{//定义接口类Inter
	public abstract void getInfo();
}
class InterClass{//定义类InnerClass
	
	public void print(){//定义类InnerClass类中的普通方法
		show(new Inter(){//调用show方法
		
	//在show方法的参数中通过匿名对象实现接口类的抽象方法，使此成为匿名内部类	
			public void getInfo(){
				System.out.println("Java匿名内部类,实现接口");
			}
		});
	}
	
	public void show(Inter i){
		i.getInfo();
	}
}

class InterClass2{
	public void print(int i,final int k){
		int x=10;
		final int y =20;
		show(new Inter(){
			public void getInfo(){
				System.out.println("print方法的final类型参数："+k);
				System.out.println("print方法的final类型局部变量："+y);
				System.out.println("print方法的非final类型参数："+i);
				System.out.println("print方法的非final类型局部变量："+x);
			}
		});
	}
	public void show(Inter i){
		i.getInfo();
	}
}

class InterClass3{
	public void print(){
		show(new Inter(){
			int x;
			{
				x=10;
			}
			public void getInfo(){
				System.out.println("x="+x);
			}
		});
	}
	public void show(Inter i){
		i.getInfo();
	}
}
public class AnonymityInner{
	public static void main(String[] args){
		new InterClass3().print();//创建inner匿名内部类的对象并调用匿名内部类的方法
	}
}