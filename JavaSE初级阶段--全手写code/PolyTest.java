class Person1{
public void tell(){
	System.out.println("父类的Person的tell()方法");
	
}
public void own(){
	System.out.println("父类自己的方法");
}
}
class Student1 extends Person1{
	//子类重写父类的方法
	public void tell(){
		System.out.println("子类的Studen的tell()方法");
	}
	//属于子类自己的方法
	public void print(){
	System.out.println("子类的Studen的print()方法");
	}
}
public class PolyTest{
	public static void main(String[] args){
		//instanceof 关键字
		Person1 per= new Student1();
		System.out.println("per属于Person类类型："+(per instanceof Person1));
		System.out.println("per属于Student类类型："+(per instanceof Student1));
		Student1 stu=(Student1)per;
		System.out.println("stu属于Person类类型："+(stu instanceof Person1));
		System.out.println("stu属于Student类类型："+(stu instanceof Student1));
		
		// 对象的多态性
		// Person1 per=new Student1();
		// Student1 stu=(Student1)per;
		 // Person1 per=new Person1();
		 // Student1 stu= (Student1)per;
		// per.own();
		// per.tell();
		// stu.tell();
		// stu.own();
		// stu.print();
		// per.print();//error 向上转型的对象不能调用子类新增的实例
		
		
	}
}