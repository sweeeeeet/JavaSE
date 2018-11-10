class Person{

public String name;
public int age;

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
	Person p3 = new Person("who");
	Person p2 = new Person("luca",17);
//	System.out.println(p2.age);
	p1.getPersonInfo();
	p2.getPersonInfo();
	p3.getPersonInfo();
}


public void print(){
	
	System.out.println("[PRINT]方法"+this);
}
}