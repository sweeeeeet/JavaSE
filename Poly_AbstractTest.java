public class Poly_AbstractTest{
	public static void main(String[] args){
		Person person=new Student("刘明");
		System.out.println(person.getPersonInfo());
		Person person2=new Teacher("张三");
		System.out.println(person2.getPersonInfo());
		Person person3=Person.getPersonObject();
		System.out.println(person3.getPersonInfo());
	}
}

abstract class Person{
	public Person(String name ){
		this.name=name;
	}
	
		private  String name ;
		
		public String getName(){
		return name;
		}
		
		public void setName(String name){
			this.name=name;
		}
	
	abstract String getPersonInfo();
	
	//静态方法可通过类名直接访问，方法内部类不允许使用任何访问修饰符
	public static Person getPersonObject(){
		//1.方法内部类
		/*
		class Worker extends Person{
			public Worker(String name){
		     super(name);
	         }
			public String getPersonInfo(){
				return "工人姓名"+this.getName();
			}
		}*/
		
		//2.匿名内部类
		return new Person("王五"){
			public String getPersonInfo(){
				return "工人姓名："+this.getName();
			}
			
		};
		
	}
}
class Student extends Person{
	public Student(String name){
		super(name);
	}
	public String getPersonInfo(){
		return "学生姓名："+this.getName();
	}
}

class Teacher extends Person{
	public Teacher(String name){
		super(name);
	}
	public String getPersonInfo(){
		return "老师姓名："+this.getName();
	}
}
