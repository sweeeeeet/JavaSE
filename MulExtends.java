class A{
	
	private String name="a类的私有属性";
	public String getName(){
		
		return name;
	}
}
class B{
	
	private int age=18;
	public int getAge(){
		return age;
	}
	
}


 class Outer{
	 
	 //内部类并且继承类A
	 private class InnerClassA extends A{
		 
		 //返回父类name属性的方法
		 public String name(){
			 
			 
			 return super.getName();
		 }
	 }
	 
	 //内部类并且继承类B
	 private class InnerClassB extends B{
		 //返回父类age属性的方法
		 public int age(){
			 
			 return super.getAge();
		 }
	 }
	 
	 //外部类中可定义与内部类同名的方法
	 public String name(){
		 
		 //调用内部类的name()方法
		 return new InnerClassA().name();
	 }
	 
	 //外部类中可定义与内部类同名的age方法
	 public int age(){
		 
		 //调用内部类的age()；
		 return new InnerClassB().age();
	 }
 }
 
 public class MulExtends{
	 
	 public static void main(String[] args){
		 
		 Outer out=new Outer();
		 System.out.println(out.name());
		 
	 }
 }