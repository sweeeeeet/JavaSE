class Person{

public String name;
public int age;
float popu=13.74f;
static double accPopu=1370536875;
public void population(){
	
	System.out.println("全国人口为"+accPopu+"人，大约为"+popu+"亿");
	
}
public  void tell(){
	
		System.out.println("全国人口为"+accPopu+"人，大约为"+popu+"亿");

}
public Person(){
	System.out.println("********产生一个新的Person无参对象********");
	
	
}
public Person(String name){
	
	this.name=name;
	System.out.println("*********产生一个新的Person一个参数对象********");
	
}
public Person(String name,int age){
	this(name);
	this.age=age;
	//System.out.println("*********产生一个新的Person两个参数对象********");
}


public void setName(String name){
	this.name=name;	
}

public void setAge(int age){
	if(age>0&&age<120){
		
		this.age=age;
	}
}
 public String getName(){
	 
	 return name;
 }	
	


public String getPersonInfo(){
	
	return "姓名："+this.name+"，年龄："+this.age;
}

public static void main(String[] args){
	Person p1 =new Person();
	Person p3 = new Person("who",15);
	Person p2 = new Person("luca",17);
	p3.setName("java");
	System.out.println(p3.getName());
	System.out.println(p1.getPersonInfo());
	System.out.println(p2.getPersonInfo());
	System.out.println(p3.getPersonInfo());
}


public void print(){
	
	System.out.println("[PRINT]方法"+this);
}
}
