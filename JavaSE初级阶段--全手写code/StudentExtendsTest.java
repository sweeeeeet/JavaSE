class Person{
public float PI =3.14f;

	public  String name="kimi";
	protected int age;
	float popu=13.74f;
	static double accPopu=1370536875;
	protected void setName(String name ){
		this.name=name;
	}
	protected String getName(){
		
		return this.name;
	}
	
	protected void setAge(int age ){
		this.age=age;
	}
	protected int  getAge(){
		
		return age;
	}
	public void setPopu(float a){
		this.popu=a;
	}
	public void population(){
		
		System.out.println("全国人口为"+accPopu+"人，大约为"+popu+"亿");
		
	}
	public  void tell(){
		
			System.out.println("全国人口为"+accPopu+"人，大约为"+popu+"亿");

	}
	public void say(){
		System.out.println("我叫"+getName()+"，今年"+getAge()+"岁，我知道圆周率为"+PI);
	}
}


class Student extends Person{
	public float PI=3.1415926535f;
	public  String name="傻逼";
	private String school;
	public void setSchool(String school){
		this.school=school;
	}
	
	public String getSchool(){
		
		return school;
	}
	public void say(){
		
		super.say();
		System.out.println("我叫"+getName()+"，今年"+getAge()+"岁，我知道圆周率为"+PI
		+"比大多数的"+super.name+"精确多了");
	}
}
public class StudentExtendsTest {


	public static void main(String[] args){
		
		
		Person per =new Person();
		per.setAge(15);
		per.setName("kimi");
		per.say();
		
		
		Student stu= new Student();
		
		stu.setAge(13);
		stu.setSchool("家里蹲大学");
		stu.say();
		
		
		// StudentExtendsTest stu= new StudentExtendsTest();
		// stu.setPopu(13.8f);
		// stu.population();
		// stu.tell();
		// Person per= new Person();
		// per.population();
	}
}